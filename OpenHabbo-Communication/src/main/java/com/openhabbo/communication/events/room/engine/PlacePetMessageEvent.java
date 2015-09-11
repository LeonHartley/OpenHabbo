package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.PlacePetMessageParser;

import java.util.function.Consumer;

public class PlacePetMessageEvent extends AbstractMessageEvent<PlacePetMessageParser> {

    public PlacePetMessageEvent(Consumer<PlacePetMessageParser> callback) {
        super(callback, PlacePetMessageParser.class);
    }
}
