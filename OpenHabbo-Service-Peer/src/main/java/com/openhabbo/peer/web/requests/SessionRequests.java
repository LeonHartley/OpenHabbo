package com.openhabbo.peer.web.requests;

import com.google.common.reflect.TypeToken;
import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.commons.json.JsonUtil;
import com.openhabbo.commons.web.requests.peer.PeerSendMessage;
import com.openhabbo.communication.sessons.SessionService;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SessionRequests {
    public static Object sendMessage(Request request, Response response) throws Exception {
        Map<String, Object> res = new HashMap<>();

        final UUID sessionId = UUID.fromString(request.params("sessionId"));

        Session session = SessionService.getInstance().getSessionById(sessionId);

        if (session == null) {
            res.put("error", "Failed to find session with ID: " + sessionId.toString());
            return res;
        }

        if (request.queryParams("message") != null) {
            session.send(createMessage(request.queryParams("messageClass"), request.queryParams("message"), res));
        } else {
            List<PeerSendMessage.PeerMsgData> messages = JsonUtil.getGsonInstance().fromJson(request.queryParams("messages"), new TypeToken<List<PeerSendMessage.PeerMsgData>>() {
            }.getType());

            if (messages != null) {
                for (PeerSendMessage.PeerMsgData message : messages) {
                    session.send(createMessage(message.getMessageClass(), message.getMessage(), res));
                }
            }

        }

        return res;
    }

    private static MessageComposer createMessage(String messageClass, String messageContents, Map<String, Object> response) throws ClassNotFoundException {
        Object obj = JsonUtil.parse(Class.forName(messageClass), messageContents);

        if (!(obj instanceof MessageComposer)) {
            response.put("error", "MessageArgs is invalid, send aborted");
            return null;
        }

        return ((MessageComposer) obj);
    }
}
