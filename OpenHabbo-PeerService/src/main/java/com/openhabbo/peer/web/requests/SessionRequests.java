package com.openhabbo.peer.web.requests;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.commons.json.JsonUtil;
import com.openhabbo.core.sessions.SessionService;
import spark.Request;
import spark.Response;

import java.util.HashMap;
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
            final String messageClass = request.queryParams("messageClass");
            final String messageContents = request.queryParams("message");

            Object obj = JsonUtil.parse(Class.forName(messageClass), messageContents);

            if(!(obj instanceof MessageComposer)) {
                res.put("error", "Message is invalid, send aborted");
                return res;
            }

            session.send(((MessageComposer) obj));
            res.put("success", "Message sent successfully");
        } else {
            // TODO: Sending multiple messages in 1 go
        }

        return res;
    }
}
