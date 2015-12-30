package com.openhabbo.commons.web.requests.peer;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.commons.json.JsonUtil;
import com.openhabbo.commons.web.requests.types.PeerServiceRequest;

import java.util.*;

public class PeerSendMessage extends PeerServiceRequest {

    private final UUID sessionId;
    private final MessageComposer messageComposer;
    private final List<MessageComposer> messageComposers;

    public PeerSendMessage(UUID sessionId, MessageComposer messageWrapper) {
        this.sessionId = sessionId;
        this.messageComposer = messageWrapper;
        this.messageComposers = null;
    }

    public PeerSendMessage(UUID sessionId, List<MessageComposer> messageWrappers) {
        this.sessionId = sessionId;
        this.messageComposer = null;
        this.messageComposers = messageWrappers;
    }

    @Override
    public Map<String, Object> getParameters() {
        return new HashMap<String, Object>() {{
            put("sessionId", sessionId.toString());
        }};
    }

    @Override
    public void applyFields(HttpRequestWithBody request) {
        if (messageComposer == null && this.messageComposers != null) {
            // we are sending multiple messages.
            List<PeerMsgData> messages = new ArrayList<>();

            for (MessageComposer messageComposer : this.messageComposers) {
                messages.add(new PeerMsgData(messageComposer.getClass().getName(), JsonUtil.stringify(messageComposer)));
            }

            request.field("messages", JsonUtil.stringify(messages));
        } else if (messageComposer != null) {
            // we only want to send 1 message.
            request.field("messageClass", this.messageComposer.getClass().getName())
                    .field("message", JsonUtil.stringify(this.messageComposer));
        }
    }

    @Override
    public String getEndpoint() {
        return "/session/:sessionId/sendMessage";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    public class PeerMsgData {
        private String messageClass;
        private String message;

        public PeerMsgData(String messageClass, String message) {
            this.messageClass = messageClass;
            this.message = message;
        }

        public String getMessageClass() {
            return messageClass;
        }

        public String getMessage() {
            return message;
        }
    }
}
