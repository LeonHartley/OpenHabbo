package com.openhabbo.commons.web.requests.master;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.types.MasterServiceRequest;

import java.util.Map;
import java.util.UUID;

public class MasterSessionRegisterMessage extends MasterServiceRequest {

    private final UUID sessionId;
    private final String serviceAlias;

    public MasterSessionRegisterMessage(UUID sessionId, String serviceAlias) {
        this.sessionId = sessionId;
        this.serviceAlias = serviceAlias;
    }

    @Override
    public Map<String, Object> getParameters() {
        return null;
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {
        request.field("sessionId", this.sessionId)
                .field("serviceAlias", this.serviceAlias);
    }

    @Override
    public String getEndpoint() {
        return "/sessions/register";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
