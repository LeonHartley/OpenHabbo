package com.openhabbo.core.sessions;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.events.EventHandler;
import com.openhabbo.api.communication.events.EventRegistry;
import com.openhabbo.api.communication.events.MessageEvent;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.core.sessions.components.MessageEventContainer;
import com.openhabbo.core.sessions.messaging.HandshakeMessageHandler;

public class PlayerSession implements Session, EventRegistry, EventHandler {
    private final MessageEventContainer messageEventContainer;

    private HandshakeMessageHandler handshakeMessageHandler;

    public PlayerSession() {
        this.messageEventContainer = new MessageEventContainer(this);

        // Event handlers would be instantiated here, although they would not be registered until
        // the session is fully initialized. Also, the messages should only be registered
        // when it's needed, any registered events that aren't needed are just a waste of memory.
        this.handshakeMessageHandler = new HandshakeMessageHandler(this);
    }

    @Override
    public void initialize() {
        this.handshakeMessageHandler.initialize();
    }

    @Override
    public void dispose() {
        this.handshakeMessageHandler.dispose();
        this.messageEventContainer.unregisterAllEvents();
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
}
