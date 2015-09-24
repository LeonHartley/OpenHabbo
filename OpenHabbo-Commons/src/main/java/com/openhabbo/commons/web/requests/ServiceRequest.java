package com.openhabbo.commons.web.requests;

import java.util.Map;

public interface ServiceRequest {
    Map<String, Object> getParameters();

    String getEndpoint();
}
