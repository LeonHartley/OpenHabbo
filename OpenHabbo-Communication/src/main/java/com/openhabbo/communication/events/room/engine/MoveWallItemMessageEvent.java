package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.MoveWallItemMessageParser;

import java.util.function.Consumer;

public class MoveWallItemMessageEvent extends AbstractMessageEvent<MoveWallItemMessageParser> {

    public MoveWallItemMessageEvent(Consumer<MoveWallItemMessageParser> callback) {
        super(callback, MoveWallItemMessageParser.class);
    }
}
