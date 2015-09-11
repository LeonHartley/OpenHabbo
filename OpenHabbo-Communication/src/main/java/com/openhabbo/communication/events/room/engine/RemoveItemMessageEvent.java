package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.RemoveItemMessageParser;

import java.util.function.Consumer;

public class RemoveItemMessageEvent extends AbstractMessageEvent<RemoveItemMessageParser> {

    public RemoveItemMessageEvent(Consumer<RemoveItemMessageParser> callback) {
        super(callback, RemoveItemMessageParser.class);
    }
}
