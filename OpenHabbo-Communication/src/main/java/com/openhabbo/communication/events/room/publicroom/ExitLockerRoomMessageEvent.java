package com.openhabbo.communication.events.room.publicroom;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.publicroom.ExitLockerRoomMessageParser;

import java.util.function.Consumer;

public class ExitLockerRoomMessageEvent extends AbstractMessageEvent<ExitLockerRoomMessageParser> {

    public ExitLockerRoomMessageEvent(Consumer<ExitLockerRoomMessageParser> callback) {
        super(callback, ExitLockerRoomMessageParser.class);
    }
}
