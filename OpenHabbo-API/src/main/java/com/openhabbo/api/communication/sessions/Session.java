package com.openhabbo.api.communication.sessions;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.events.EventHandler;

public interface Session extends EventHandler {
    void initialize();

    void dispose();

    void send(MessageComposer composer);
}
