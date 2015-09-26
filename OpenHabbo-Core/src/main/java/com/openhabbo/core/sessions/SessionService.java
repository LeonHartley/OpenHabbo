package com.openhabbo.core.sessions;

import com.openhabbo.api.communication.sessions.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SessionService {
    private static SessionService sessionFactory;

    private static final Logger log = LogManager.getLogger(SessionService.class.getName());

    public static final AttributeKey<Session> SESSION_ATTRIBUTE = AttributeKey.valueOf("OpenHabbo.Session");
//    public static final AttributeKey<UUID> CHANNEL_ID_ATTRIBUTE = AttributeKey.valueOf("OpenHabbo.Session.ChannelId");

    private final Map<UUID, Session> sessions;
    private final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public SessionService() {
        this.sessions = new ConcurrentHashMap<>();
    }

    public Session createSession(Channel channel) {
        final UUID sessionId = UUID.randomUUID();
        final PlayerSession playerSession = new PlayerSession(sessionId, channel);

        channel.attr(SESSION_ATTRIBUTE).set(playerSession);

        this.channels.add(channel);
        this.sessions.put(sessionId, playerSession);

        return playerSession;
    }

    public Session getSessionById(UUID id) {
        return this.sessions.get(id);
    }

    public static SessionService getInstance() {
        if(sessionFactory == null) {
            sessionFactory = new SessionService();
        }

        return sessionFactory;
    }
}
