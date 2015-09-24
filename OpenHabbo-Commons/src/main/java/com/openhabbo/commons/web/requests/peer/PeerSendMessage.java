package com.openhabbo.commons.web.requests.peer;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.commons.web.requests.types.PeerServiceRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PeerSendMessage extends PeerServiceRequest {

    private final UUID sessionId;
    private final OutgoingMessageWrapper messageWrapper;

    public PeerSendMessage(UUID sessionId, OutgoingMessageWrapper messageWrapper) {
        this.sessionId = sessionId;
        this.messageWrapper = messageWrapper;
    }

    @Override
    public Map<String, Object> getParameters() {
        return new HashMap<String, Object>() {{
            put("sessionId", sessionId.toString());
        }};
    }

    @Override
    public String getEndpoint() {
        return "/session/:sessionId/sendMessage";
    }
}
