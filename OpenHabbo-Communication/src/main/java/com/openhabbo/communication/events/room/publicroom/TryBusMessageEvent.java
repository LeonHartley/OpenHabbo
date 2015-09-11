package com.openhabbo.communication.events.room.publicroom;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.publicroom.TryBusMessageParser;

import java.util.function.Consumer;

public class TryBusMessageEvent extends AbstractMessageEvent<TryBusMessageParser> {

    public TryBusMessageEvent(Consumer<TryBusMessageParser> callback) {
        super(callback, TryBusMessageParser.class);
    }
}
