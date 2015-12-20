package com.openhabbo.core.sessions.messaging;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.openhabbo.api.communication.sessions.SessionComponent;
import com.openhabbo.api.data.players.Player;
import com.openhabbo.commons.json.JsonUtil;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.storage.AuthenticateSessionMessage;
import com.openhabbo.communication.composers.handshake.AuthenticationOKMessageComposer;
import com.openhabbo.communication.composers.notifications.MOTDNotificationMessageComposer;
import com.openhabbo.communication.events.handshake.SSOTicketMessageEvent;
import com.openhabbo.communication.parsers.handshake.SSOTicketMessageParser;
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
        this.playerSession.registerEvent(new SSOTicketMessageEvent(this::onAuthRequest));
    }

    @Override
    public void dispose() {
        if(!this.authRequestReceived) {
            this.playerSession.unregisterEvent(SSOTicketMessageEvent.class);
        }
    }

    public void onAuthRequest(SSOTicketMessageParser parser) {
        log.trace("Player attempting to login with ticket \"{}\"", parser.getSsoTicket());

        this.authRequestReceived = true;

        // submit authentication request to an auth service.
        log.trace("Session ID: " + this.playerSession.getSessionId());

        WebClient.getInstance().dispatchRequest("storageservice-1", new AuthenticateSessionMessage(parser.getSsoTicket()), (data) -> {
            final boolean authenticationSuccessful = data.getObject().getBoolean("authenticated");

            if(authenticationSuccessful) {
                try {
                    Player player = JsonUtil.parse(Player.class, data.getObject().getJSONObject("data").toString());

                    if(player != null) {
                        this.playerSession.send(new AuthenticationOKMessageComposer());
                        this.playerSession.send(new MOTDNotificationMessageComposer("Hi " + player.getUsername() + "!\n\nWelcome to OpenHabbo, the world's first distributed Habbo Hotel private server!"));
                    }
                } catch(Exception e) {
                    this.playerSession.send(new MOTDNotificationMessageComposer("An unknown error occurred while loading your player data!"));
                }
            } else {
                // obv wont show this in production, will just disconnect them.:p
                this.playerSession.send(new MOTDNotificationMessageComposer("Failed to authenticate!"));
            }
        });

        this.playerSession.unregisterEvent(SSOTicketMessageEvent.class);
    }
}