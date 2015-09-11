package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.PlaceObjectMessageParser;

import java.util.function.Consumer;

public class PlaceObjectMessageEvent extends AbstractMessageEvent<PlaceObjectMessageParser> {

    public PlaceObjectMessageEvent(Consumer<PlaceObjectMessageParser> callback) {
        super(callback, PlaceObjectMessageParser.class);
    }
}
