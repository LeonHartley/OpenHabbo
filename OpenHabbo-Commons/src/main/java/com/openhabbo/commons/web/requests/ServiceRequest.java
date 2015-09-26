package com.openhabbo.commons.web.requests;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.util.Map;

public interface ServiceRequest {
    Map<String, Object> getParameters();

    void applyFields(HttpRequestWithBody request);

    String getEndpoint();

    HttpMethod getMethod();
}
