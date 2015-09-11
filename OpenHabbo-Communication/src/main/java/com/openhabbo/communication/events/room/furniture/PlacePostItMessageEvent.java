package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.PlacePostItMessageParser;

import java.util.function.Consumer;

public class PlacePostItMessageEvent extends AbstractMessageEvent<PlacePostItMessageParser> {

    public PlacePostItMessageEvent(Consumer<PlacePostItMessageParser> callback) {
        super(callback, PlacePostItMessageParser.class);
    }
}
