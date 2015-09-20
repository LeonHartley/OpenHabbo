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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionFactory {
    private static SessionFactory sessionFactory;

    private static final Logger log = LogManager.getLogger(SessionFactory.class.getName());

    public static final AttributeKey<Session> SESSION_ATTRIBUTE = AttributeKey.valueOf("OpenHabbo.Session");
    public static final AttributeKey<Session> CHANNEL_ID_ATTRIBUTE = AttributeKey.valueOf("OpenHabbo.Session.ChannelId");

    private final AtomicInteger sessionIds = new AtomicInteger();
    private final Map<Integer, Session> sessions;

    private final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public SessionFactory() {
        this.sessions = new ConcurrentHashMap<>();
    }

    public Session createSession(Channel channel) {
        final PlayerSession playerSession = new PlayerSession(channel);

        channel.attr(SESSION_ATTRIBUTE).set(playerSession);

        channels.add(channel);
        return playerSession;
    }

    public static SessionFactory getInstance() {
        if(sessionFactory == null) {
            sessionFactory = new SessionFactory();
        }

        return sessionFactory;
    }
}
