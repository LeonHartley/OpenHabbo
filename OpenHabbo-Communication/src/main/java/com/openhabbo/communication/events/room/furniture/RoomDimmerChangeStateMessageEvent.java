package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.RoomDimmerChangeStateMessageParser;

import java.util.function.Consumer;

public class RoomDimmerChangeStateMessageEvent extends AbstractMessageEvent<RoomDimmerChangeStateMessageParser> {

    public RoomDimmerChangeStateMessageEvent(Consumer<RoomDimmerChangeStateMessageParser> callback) {
        super(callback, RoomDimmerChangeStateMessageParser.class);
    }
}
