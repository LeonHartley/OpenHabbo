package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.TryLoginMessageParser;

import java.util.function.Consumer;

public class TryLoginMessageEvent extends AbstractMessageEvent<TryLoginMessageParser> {

    public TryLoginMessageEvent(Consumer<TryLoginMessageParser> callback) {
        super(callback, TryLoginMessageParser.class);
    }
}
