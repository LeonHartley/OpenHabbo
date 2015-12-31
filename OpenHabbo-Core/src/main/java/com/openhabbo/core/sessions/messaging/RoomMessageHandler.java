package com.openhabbo.core.sessions.messaging;

import com.openhabbo.api.communication.sessions.SessionComponent;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.room.RoomLoadMessage;
import com.openhabbo.communication.events.room.session.OpenFlatConnectionMessageEvent;
import com.openhabbo.communication.parsers.room.session.OpenFlatConnectionMessageParser;
import com.openhabbo.core.sessions.PlayerSession;

public class RoomMessageHandler implements SessionComponent {

    private final PlayerSession playerSession;

    public RoomMessageHandler(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    @Override
    public void initialize() {
        this.playerSession.registerEvent(new OpenFlatConnectionMessageEvent(this::openFlatConnection));
    }

    @Override
    public void dispose() {
        this.playerSession.unregisterEvent(OpenFlatConnectionMessageEvent.class);
    }

    public void openFlatConnection(OpenFlatConnectionMessageParser parser) {
        WebClient.getInstance().dispatchRequest("roomservice-1",
                new RoomLoadMessage(parser.getRoomId(), this.playerSession.getSessionId(), parser.getPassword()));
    }
}
