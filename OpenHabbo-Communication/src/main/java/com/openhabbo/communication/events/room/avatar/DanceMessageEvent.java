package com.openhabbo.communication.events.room.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.avatar.DanceMessageParser;

import java.util.function.Consumer;

public class DanceMessageEvent extends AbstractMessageEvent<DanceMessageParser> {

    public DanceMessageEvent(Consumer<DanceMessageParser> callback) {
        super(callback, DanceMessageParser.class);
    }
}
