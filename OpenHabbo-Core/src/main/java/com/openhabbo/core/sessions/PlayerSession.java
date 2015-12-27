package com.openhabbo.core.sessions;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.events.EventHandler;
import com.openhabbo.api.communication.events.EventRegistry;
import com.openhabbo.api.communication.events.MessageEvent;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.api.communication.sessions.util.DisconnectReason;
import com.openhabbo.api.data.players.Player;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.master.MasterSessionRegisterMessage;
import com.openhabbo.commons.web.requests.master.MasterSessionUnregisterMessage;
import com.openhabbo.config.services.OpenHabboService;
import com.openhabbo.core.sessions.components.MessageEventContainer;
import com.openhabbo.core.sessions.messaging.HandshakeMessageHandler;
import com.openhabbo.core.sessions.messaging.MessengerMessageHandler;
import com.openhabbo.core.sessions.messaging.PlayerMessageHandler;
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
    private final PlayerMessageHandler playerMessageHandler;
    private final MessengerMessageHandler messengerMessageHandler;

    private Player playerData;

    public PlayerSession(UUID sessionId, Channel channel) {
        this.sessionId = sessionId;
        this.messageEventContainer = new MessageEventContainer(this);
        this.channel = channel;

        // Event handlers would be instantiated here, although they would not be registered until
        // the session is fully initialized. Also, the messages should only be registered
        // when it's needed, any registered events that aren't needed are just a waste of memory.
        this.handshakeMessageHandler = new HandshakeMessageHandler(this);
        this.playerMessageHandler = new PlayerMessageHandler(this);
        this.messengerMessageHandler = new MessengerMessageHandler(this);
    }

    @Override
    public void initialize() {
        this.handshakeMessageHandler.initialize();
        this.playerMessageHandler.initialize();
        this.messengerMessageHandler.initialize();

        this.initialized = true;

        WebClient.getInstance().dispatchRequest("master", new MasterSessionRegisterMessage(this.getSessionId(), "peerservice-1"));
    }

    @Override
    public void dispose() {
        this.handshakeMessageHandler.dispose();
        this.playerMessageHandler.dispose();

        this.messageEventContainer.unregisterAllEvents();

        if(this.isInitialized()) {
            WebClient.getInstance().dispatchRequest("master", new MasterSessionUnregisterMessage(this.getSessionId()));
        }
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
    public void unregisterEvent(Class<? extends MessageEvent> event) {
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

    @Override
    public Player getPlayerData() {
        return this.playerData;
    }

    @Override
    public void setPlayerData(Player playerData) {
        this.playerData = playerData;
    }
}
