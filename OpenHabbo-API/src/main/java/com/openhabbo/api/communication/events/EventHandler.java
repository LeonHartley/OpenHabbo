package com.openhabbo.api.communication.events;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;

public interface EventHandler {
    void handleEvent(short headerId, IncomingMessageWrapper messageWrapper);
}
