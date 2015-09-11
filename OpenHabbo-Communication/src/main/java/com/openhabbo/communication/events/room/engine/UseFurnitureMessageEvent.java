package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.UseFurnitureMessageParser;

import java.util.function.Consumer;

public class UseFurnitureMessageEvent extends AbstractMessageEvent<UseFurnitureMessageParser> {

    public UseFurnitureMessageEvent(Consumer<UseFurnitureMessageParser> callback) {
        super(callback, UseFurnitureMessageParser.class);
    }
}
