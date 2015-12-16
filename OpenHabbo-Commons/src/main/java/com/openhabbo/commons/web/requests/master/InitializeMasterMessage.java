package com.openhabbo.commons.web.requests.master;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.types.MasterServiceRequest;

import java.util.Map;

public class InitializeMasterMessage extends MasterServiceRequest {

    public InitializeMasterMessage() {
    }

    @Override
    public Map<String, Object> getParameters() {
        return null;
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {

    }

    @Override
    public String getEndpoint() {
        return "/initialize";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}
