package com.openhabbo.core.sessions.messaging;

import com.openhabbo.api.communication.sessions.SessionComponent;
import com.openhabbo.communication.composers.friendlist.MessengerInitMessageComposer;
import com.openhabbo.communication.events.friendlist.MessengerInitMessageEvent;
import com.openhabbo.communication.parsers.friendlist.MessengerInitMessageParser;
import com.openhabbo.core.sessions.PlayerSession;

public class MessengerMessageHandler implements SessionComponent {

    private final PlayerSession playerSession;

    public MessengerMessageHandler(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    @Override
    public void initialize() {
        this.playerSession.registerEvent(new MessengerInitMessageEvent(this::onMessengerInit));
    }

    @Override
    public void dispose() {
        this.playerSession.unregisterEvent(MessengerInitMessageEvent.class);
    }

    public void onMessengerInit(MessengerInitMessageParser parser) {
        // TODO: initialize the messenger shit.. (idk if i will be having a seperate microservice for this..we'll see..

        this.playerSession.send(new MessengerInitMessageComposer());
        this.playerSession.unregisterEvent(MessengerInitMessageEvent.class);
    }
}
