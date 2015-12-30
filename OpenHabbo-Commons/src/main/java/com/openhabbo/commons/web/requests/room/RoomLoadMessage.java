package com.openhabbo.commons.web.requests.room;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.commons.web.requests.types.RoomServiceRequest;

import java.util.Map;
import java.util.UUID;

public class RoomLoadMessage extends RoomServiceRequest {
    private int roomId;
    private UUID sessionId;
    private String password;

    public RoomLoadMessage(int roomId, UUID sessionId, String password) {
        this.roomId = roomId;
        this.sessionId = sessionId;
        this.password = password;
    }

    @Override
    public Map<String, Object> getParameters() {
        return null;
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {
        request.field("roomId", this.roomId)
                .field("password", this.password)
                .field("sessionId", this.sessionId);
    }

    @Override
    public String getEndpoint() {
        return "/room/load";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}

