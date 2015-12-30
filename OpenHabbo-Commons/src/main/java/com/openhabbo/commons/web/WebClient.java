package com.openhabbo.commons.web;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.ServiceRequest;
import com.openhabbo.commons.web.requests.master.InitializeMasterMessage;
import com.openhabbo.commons.web.requests.types.MasterServiceRequest;
import com.openhabbo.commons.web.requests.types.PeerServiceRequest;
import com.openhabbo.commons.web.requests.types.RoomServiceRequest;
import com.openhabbo.commons.web.requests.types.StorageServiceRequest;
import com.openhabbo.config.OpenHabboServiceConfiguration;
import com.openhabbo.config.services.OpenHabboService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.function.Consumer;

public class WebClient {
    private static final Logger log = LogManager.getLogger(WebClient.class.getName());
    public static final String AUTHENTICATION_HEADER = "OpenHabbo-Authentication";
    private static WebClient webClient;

    private OpenHabboServiceConfiguration serviceConfiguration;

    public WebClient() {

    }

    public void initialize(OpenHabboServiceConfiguration serviceConfiguration) {
        this.serviceConfiguration = serviceConfiguration;

        this.dispatchRequest("master", new InitializeMasterMessage(), null);
    }

    public void dispatchRequest(String serviceAlias, ServiceRequest serviceRequest) {
        this.dispatchRequest(serviceAlias, serviceRequest, null);
    }

    public void dispatchRequest(String serviceAlias, ServiceRequest serviceRequest, Consumer<JsonNode> callback) {
        if (this.serviceConfiguration == null) {
            log.warn("WebClient is not initialized, no services could be found");
            return;
        }

        OpenHabboService service = null;

        if (serviceRequest instanceof PeerServiceRequest) {
            service = this.serviceConfiguration.getPeerServices().get(serviceAlias);
        } else if(serviceRequest instanceof MasterServiceRequest) {
            service = this.serviceConfiguration.getMasterService();
        } else if(serviceRequest instanceof StorageServiceRequest) {
            service = this.serviceConfiguration.getStorageServices().get(serviceAlias);
        } else if(serviceRequest instanceof RoomServiceRequest) {
            service = this.serviceConfiguration.getRoomServices().get(serviceAlias);
        }

        if (service == null) {
            log.warn("Failed to find service, request cancelled");
            return;
        }

        String url = "http://" + service.getUrl() + serviceRequest.getEndpoint();
        final Map<String, Object> parameters = serviceRequest.getParameters();

        if (parameters != null) {
            for (Map.Entry<String, Object> urlParam : parameters.entrySet()) {
                url = url.replace(":" + urlParam.getKey(), urlParam.getValue().toString());
            }
        }

        HttpRequest request = this.createRequest(serviceRequest.getMethod(), url);

        if (request == null) {
            return;
        }

        request.header(AUTHENTICATION_HEADER, this.serviceConfiguration.getAuthenticationToken());

        if (serviceRequest.getMethod() != HttpMethod.GET) {
            serviceRequest.applyFields(((HttpRequestWithBody) request));
        }

        if (callback == null) {
            request.asStringAsync();
        } else {
            request.asJsonAsync(new Callback<JsonNode>() {
                @Override
                public void completed(HttpResponse<JsonNode> httpResponse) {
                    try {
                        callback.accept(httpResponse.getBody());
                    } catch(Exception e) {
                        log.error("Unhandled WebClient exception", e);
                    }
                }

                @Override
                public void failed(UnirestException e) {
                    log.error("Unhandled Unirest exception", e);
                }

                @Override
                public void cancelled() {
                    // todo: handle these.
                }
            });
        }
    }

    private HttpRequest createRequest(HttpMethod method, String url) {
        switch (method) {
            case GET:
                return Unirest.get(url);

            case POST:
                return Unirest.post(url);
        }

        return null;
    }

    public static WebClient getInstance() {
        if (webClient == null) {
            webClient = new WebClient();
        }

        return webClient;
    }
}
