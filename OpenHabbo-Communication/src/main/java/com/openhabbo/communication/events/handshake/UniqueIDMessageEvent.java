package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.UniqueIDMessageParser;

import java.util.function.Consumer;

public class UniqueIDMessageEvent extends AbstractMessageEvent<UniqueIDMessageParser> {

    public UniqueIDMessageEvent(Consumer<UniqueIDMessageParser> callback) {
        super(callback, UniqueIDMessageParser.class);
    }
}
