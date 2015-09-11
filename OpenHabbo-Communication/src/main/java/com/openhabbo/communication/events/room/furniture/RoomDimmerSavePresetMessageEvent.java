package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.RoomDimmerSavePresetMessageParser;

import java.util.function.Consumer;

public class RoomDimmerSavePresetMessageEvent extends AbstractMessageEvent<RoomDimmerSavePresetMessageParser> {

    public RoomDimmerSavePresetMessageEvent(Consumer<RoomDimmerSavePresetMessageParser> callback) {
        super(callback, RoomDimmerSavePresetMessageParser.class);
    }
}
