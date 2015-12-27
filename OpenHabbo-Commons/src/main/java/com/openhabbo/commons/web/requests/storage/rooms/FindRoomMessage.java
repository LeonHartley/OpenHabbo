package com.openhabbo.commons.web.requests.storage.rooms;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.types.StorageServiceRequest;

import java.util.Map;

public class FindRoomMessage extends StorageServiceRequest {
    private int roomId;

    public FindRoomMessage(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {
        request.field("roomId", this.roomId);
    }

    @Override
    public String getEndpoint() {
        return "/room/find";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}

