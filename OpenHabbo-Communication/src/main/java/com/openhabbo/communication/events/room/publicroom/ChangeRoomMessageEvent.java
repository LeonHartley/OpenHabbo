package com.openhabbo.communication.events.room.publicroom;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.publicroom.ChangeRoomMessageParser;

import java.util.function.Consumer;

public class ChangeRoomMessageEvent extends AbstractMessageEvent<ChangeRoomMessageParser> {

    public ChangeRoomMessageEvent(Consumer<ChangeRoomMessageParser> callback) {
        super(callback, ChangeRoomMessageParser.class);
    }
}
