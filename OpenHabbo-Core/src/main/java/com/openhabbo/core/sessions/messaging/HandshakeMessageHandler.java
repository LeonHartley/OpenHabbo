package com.openhabbo.core.sessions.messaging;

import com.openhabbo.api.communication.sessions.SessionComponent;
import com.openhabbo.api.data.players.Player;
import com.openhabbo.commons.json.JsonUtil;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.storage.AuthenticateSessionMessage;
import com.openhabbo.communication.composers.handshake.AuthenticationOKMessageComposer;
import com.openhabbo.communication.composers.handshake.SessionParamsMessageComposer;
import com.openhabbo.communication.composers.notifications.MOTDNotificationMessageComposer;
import com.openhabbo.communication.events.handshake.InitCryptoMessageEvent;
import com.openhabbo.communication.events.handshake.SSOTicketMessageEvent;
import com.openhabbo.communication.events.users.GetMOTDMessageEvent;
import com.openhabbo.communication.parsers.handshake.InitCryptoMessageParser;
import com.openhabbo.communication.parsers.handshake.SSOTicketMessageParser;
import com.openhabbo.communication.parsers.users.GetMOTDMessageParser;
import com.openhabbo.core.sessions.PlayerSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HandshakeMessageHandler implements SessionComponent {
    private static final Logger log = LogManager.getLogger(HandshakeMessageHandler.class);

    private final PlayerSession playerSession;
    private boolean authRequestReceived = false;

    public HandshakeMessageHandler(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    @Override
    public void initialize() {
        this.playerSession.registerEvent(new InitCryptoMessageEvent(this::onInitCrypto));
        this.playerSession.registerEvent(new SSOTicketMessageEvent(this::onAuthRequest));
        this.playerSession.registerEvent(new GetMOTDMessageEvent(this::onGetMOTD));
    }

    @Override
    public void dispose() {
        this.playerSession.unregisterEvent(InitCryptoMessageEvent.class);
        this.playerSession.unregisterEvent(SSOTicketMessageEvent.class);
    }

    public void onInitCrypto(InitCryptoMessageParser parser) {
        this.playerSession.send(new SessionParamsMessageComposer());
    }

    public void onAuthRequest(SSOTicketMessageParser parser) {
        log.trace("Player attempting to login with ticket \"{}\"", parser.getSsoTicket());

        this.authRequestReceived = true;

        // submit authentication request to an auth service.
        log.trace("Session ID: " + this.playerSession.getSessionId());

        log.info("Authentication requested");
        long time = System.currentTimeMillis();

        WebClient.getInstance().dispatchRequest("storageservice-1", new AuthenticateSessionMessage(parser.getSsoTicket()), (data) -> {
            final boolean authenticationSuccessful = data.getObject().getBoolean("authenticated");

            if (authenticationSuccessful) {
                try {
                    Player player = JsonUtil.parse(Player.class, data.getObject().getJSONObject("data").toString());

                    if (player != null) {
                        this.playerSession.setPlayerData(player);

                        log.trace("Authentication success! Took {}ms", System.currentTimeMillis() - time);

                        this.playerSession.send(new AuthenticationOKMessageComposer());
                    }
                } catch (Exception e) {
                    this.playerSession.send(new MOTDNotificationMessageComposer("An unknown error occurred while loading your player data!"));
                }
            } else {
                // obv wont show this in production, will just disconnect them.:p
                this.playerSession.send(new MOTDNotificationMessageComposer("Failed to authenticate!"));
            }
        });

        this.playerSession.unregisterEvent(SSOTicketMessageEvent.class);
    }

    public void onGetMOTD(GetMOTDMessageParser parser) {
        if (this.playerSession.getPlayerData() == null) {
            return;
        }

        this.playerSession.send(new MOTDNotificationMessageComposer("Hi " + this.playerSession.getPlayerData().getUsername() + "!\n\nWelcome to OpenHabbo, the world's first distributed Habbo Hotel private server!"));
    }
}