package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.PongMessageParser;

import java.util.function.Consumer;

public class PongMessageEvent extends AbstractMessageEvent<PongMessageParser> {

    public PongMessageEvent(Consumer<PongMessageParser> callback) {
        super(callback, PongMessageParser.class);
    }
}
