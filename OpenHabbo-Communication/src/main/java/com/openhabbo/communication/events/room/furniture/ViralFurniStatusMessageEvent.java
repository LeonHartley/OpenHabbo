package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.ViralFurniStatusMessageParser;

import java.util.function.Consumer;

public class ViralFurniStatusMessageEvent extends AbstractMessageEvent<ViralFurniStatusMessageParser> {

    public ViralFurniStatusMessageEvent(Consumer<ViralFurniStatusMessageParser> callback) {
        super(callback, ViralFurniStatusMessageParser.class);
    }
}
