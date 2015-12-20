package com.openhabbo.commons.web.requests.storage;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.types.StorageServiceRequest;

import java.util.Map;

public class AuthenticateSessionMessage extends StorageServiceRequest {
    private String authenticationTicket;

    public AuthenticateSessionMessage(String authenticationTicket) {
        this.authenticationTicket = authenticationTicket;
    }

    @Override
    public Map<String, Object> getParameters() {
        return null;
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {
        request.field("authenticationTicket", authenticationTicket);
    }

    @Override
    public String getEndpoint() {
        return "/player/authenticate";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
