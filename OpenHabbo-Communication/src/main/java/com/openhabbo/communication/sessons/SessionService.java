package com.openhabbo.communication.sessons;


import com.openhabbo.api.communication.sessions.Session;
import io.netty.channel.Channel;

import java.util.UUID;

public abstract class SessionService {
    private static SessionService instance;

    public abstract Session createSession(Channel channel);

    public abstract Session getSessionById(UUID id);

    public abstract void destroySession(UUID id, Channel channel);

    public static SessionService getInstance() {
        return instance;
    }

    public static void set(SessionService instance) {
        SessionService.instance = instance;
    }
}