package com.openhabbo.core.sessions.messaging;

import com.openhabbo.api.communication.sessions.SessionComponent;
import com.openhabbo.communication.events.handshake.SSOTicketMessageEvent;
import com.openhabbo.communication.parsers.handshake.SSOTicketMessageParser;
import com.openhabbo.core.sessions.PlayerSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HandshakeMessageHandler implements SessionComponent {
    private static final Logger log = LogManager.getLogger(HandshakeMessageHandler.class);

    private final PlayerSession playerSession;

    public HandshakeMessageHandler(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    @Override
    public void initialize() {
        this.playerSession.registerEvent(new SSOTicketMessageEvent(this::onAuthRequest));
    }

    @Override
    public void dispose() {
        this.playerSession.unregisterEvent(SSOTicketMessageEvent.class);
    }

    public void onAuthRequest(SSOTicketMessageParser parser) {
        log.info("Player attempting to login with ticket \"{}\"", "");
    }
}
