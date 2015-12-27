package com.openhabbo.commons.web.requests.storage.rooms;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.types.StorageServiceRequest;

import java.util.Map;

public class FindOwnRoomsMessage extends StorageServiceRequest {
    private final int playerId;

    public FindOwnRoomsMessage(final int playerId) {
        this.playerId = playerId;
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {
        request.field("playerId", this.playerId);
    }

    @Override
    public String getEndpoint() {
        return "/rooms/findOwn";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
