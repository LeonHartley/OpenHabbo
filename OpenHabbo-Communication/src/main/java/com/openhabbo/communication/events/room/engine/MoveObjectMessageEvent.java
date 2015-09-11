package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.MoveObjectMessageParser;

import java.util.function.Consumer;

public class MoveObjectMessageEvent extends AbstractMessageEvent<MoveObjectMessageParser> {

    public MoveObjectMessageEvent(Consumer<MoveObjectMessageParser> callback) {
        super(callback, MoveObjectMessageParser.class);
    }
}
