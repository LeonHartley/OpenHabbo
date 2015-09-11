package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.DisconnectMessageParser;

import java.util.function.Consumer;

public class DisconnectMessageEvent extends AbstractMessageEvent<DisconnectMessageParser> {

    public DisconnectMessageEvent(Consumer<DisconnectMessageParser> callback) {
        super(callback, DisconnectMessageParser.class);
    }
}
