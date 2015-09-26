package com.openhabbo.commons.web.requests.master;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.types.MasterServiceRequest;

import java.util.Map;
import java.util.UUID;

public class MasterSessionUnregisterMessage extends MasterServiceRequest {

    private final UUID sessionId;

    public MasterSessionUnregisterMessage(UUID sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public Map<String, Object> getParameters() {
        return null;
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {
        request.field("sessionId", this.sessionId);
    }

    @Override
    public String getEndpoint() {
        return "/sessions/unregister";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
