package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.GetRoomEntryDataMessageParser;

import java.util.function.Consumer;

public class GetRoomEntryDataMessageEvent extends AbstractMessageEvent<GetRoomEntryDataMessageParser> {

    public GetRoomEntryDataMessageEvent(Consumer<GetRoomEntryDataMessageParser> callback) {
        super(callback, GetRoomEntryDataMessageParser.class);
    }
}
