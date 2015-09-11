package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.UseWallItemMessageParser;

import java.util.function.Consumer;

public class UseWallItemMessageEvent extends AbstractMessageEvent<UseWallItemMessageParser> {

    public UseWallItemMessageEvent(Consumer<UseWallItemMessageParser> callback) {
        super(callback, UseWallItemMessageParser.class);
    }
}
