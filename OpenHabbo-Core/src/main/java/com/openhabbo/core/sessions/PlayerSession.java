package com.openhabbo.core.sessions;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.events.EventHandler;
import com.openhabbo.api.communication.events.EventRegistry;
import com.openhabbo.api.communication.events.MessageEvent;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.api.communication.sessions.util.DisconnectReason;
import com.openhabbo.core.sessions.components.MessageEventContainer;
import com.openhabbo.core.sessions.messaging.HandshakeMessageHandler;
import io.netty.channel.Channel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class PlayerSession implements Session, EventRegistry {
    private final Logger log = LogManager.getLogger(PlayerSession.class.getName());

    private final UUID sessionId;
    private final MessageEventContainer messageEventContainer;
    private final Channel channel;

    private boolean initialized = false;

    private final HandshakeMessageHandler handshakeMessageHandler;

    public PlayerSession(UUID sessionId, Channel channel) {
        this.sessionId = sessionId;
        this.messageEventContainer = new MessageEventContainer(this);
        this.channel = channel;

        // Event handlers would be instantiated here, although they would not be registered until
        // the session is fully initialized. Also, the messages should only be registered
        // when it's needed, any registered events that aren't needed are just a waste of memory.
        this.handshakeMessageHandler = new HandshakeMessageHandler(this);
    }

    @Override
    public void initialize() {
        this.handshakeMessageHandler.initialize();

        this.initialized = true;
    }

    @Override
    public void dispose() {
        this.handshakeMessageHandler.dispose();
        this.messageEventContainer.unregisterAllEvents();
    }

    @Override
    public void send(MessageComposer composer) {
        this.channel.writeAndFlush(composer);
    }

    @Override
    public void disconnect(DisconnectReason reason) {
        // Log the disconnection along with the reason.
        this.channel.disconnect();
    }

    @Override
    public void registerEvent(MessageEvent event) {
        this.messageEventContainer.registerEvent(event);
    }

    @Override
    public void unregisterEvent(Class event) {
        this.messageEventContainer.unregisterEvent(event);
    }

    @Override
    public void handleEvent(short headerId, IncomingMessageWrapper messageWrapper) {
        this.messageEventContainer.handleEvent(headerId, messageWrapper);
    }

    public UUID getSessionId() {
        return sessionId;
    }

    @Override
    public boolean isInitialized() {
        return this.initialized;
    }
}
