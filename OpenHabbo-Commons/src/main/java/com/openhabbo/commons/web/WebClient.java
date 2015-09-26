package com.openhabbo.commons.web;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.ServiceRequest;
import com.openhabbo.commons.web.requests.types.PeerServiceRequest;
import com.openhabbo.config.OpenHabboServiceConfiguration;
import com.openhabbo.config.services.OpenHabboService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class WebClient {
    private static final Logger log = LogManager.getLogger(WebClient.class.getName());
    public static final String AUTHENTICATION_HEADER = "OpenHabbo-Authentication";
    private static WebClient webClient;

    private OpenHabboServiceConfiguration serviceConfiguration;

    public WebClient() {

    }

    public void initialize(OpenHabboServiceConfiguration serviceConfiguration) {
        this.serviceConfiguration = serviceConfiguration;
    }

    public void submitRequest(String serviceAlias, ServiceRequest serviceRequest, Callback<JsonNode> callback) {
        if(this.serviceConfiguration == null) {
            log.warn("WebClient is not initialized, no services could be found");
            return;
        }

        OpenHabboService service = null;

        if(serviceRequest instanceof PeerServiceRequest) {
            service = this.serviceConfiguration.getPeerServices().get(serviceAlias);
        }

        if(service == null) {
            log.warn("Failed to find service, request cancelled");
            return;
        }

        String url = "http://" + service.getUrl() + serviceRequest.getEndpoint();

        for(Map.Entry<String, Object> urlParam : serviceRequest.getParameters().entrySet()) {
            url = url.replace(":" + urlParam.getKey(), urlParam.getValue().toString());
        }

        HttpRequest request = this.createRequest(serviceRequest.getMethod(), url);

        if(request == null) {
            return;
        }

        request.header(AUTHENTICATION_HEADER, this.serviceConfiguration.getAuthenticationToken());

        if(serviceRequest.getMethod() != HttpMethod.GET) {
            serviceRequest.applyFields(((HttpRequestWithBody) request));
        }

        request.asJsonAsync(callback);
    }

    private HttpRequest createRequest(HttpMethod method, String url) {
        switch(method) {
            case GET:
                return Unirest.get(url);

            case POST:
                return Unirest.post(url);
        }

        return null;
    }

    public static WebClient getInstance() {
        if(webClient == null) {
            webClient = new WebClient();
        }

        return webClient;
    }
}
