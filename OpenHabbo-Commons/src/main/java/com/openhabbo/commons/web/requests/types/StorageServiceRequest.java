package com.openhabbo.commons.web.requests.types;

import com.openhabbo.commons.web.requests.ServiceRequest;

import java.util.Map;

public abstract class StorageServiceRequest implements ServiceRequest {
    @Override
    public Map<String, Object> getParameters() {
        return null;
    }

}
