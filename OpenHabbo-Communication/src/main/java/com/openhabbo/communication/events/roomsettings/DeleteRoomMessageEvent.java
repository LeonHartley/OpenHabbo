package com.openhabbo.communication.events.roomsettings;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.roomsettings.DeleteRoomMessageParser;

import java.util.function.Consumer;

public class DeleteRoomMessageEvent extends AbstractMessageEvent<DeleteRoomMessageParser> {

    public DeleteRoomMessageEvent(Consumer<DeleteRoomMessageParser> callback) {
        super(callback, DeleteRoomMessageParser.class);
    }
}
