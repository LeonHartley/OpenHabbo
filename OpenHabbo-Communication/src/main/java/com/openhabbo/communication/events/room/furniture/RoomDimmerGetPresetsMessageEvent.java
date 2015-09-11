package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.RoomDimmerGetPresetsMessageParser;

import java.util.function.Consumer;

public class RoomDimmerGetPresetsMessageEvent extends AbstractMessageEvent<RoomDimmerGetPresetsMessageParser> {

    public RoomDimmerGetPresetsMessageEvent(Consumer<RoomDimmerGetPresetsMessageParser> callback) {
        super(callback, RoomDimmerGetPresetsMessageParser.class);
    }
}
