package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.RoomTextSearchMessageParser;

import java.util.function.Consumer;

public class RoomTextSearchMessageEvent extends AbstractMessageEvent<RoomTextSearchMessageParser> {

    public RoomTextSearchMessageEvent(Consumer<RoomTextSearchMessageParser> callback) {
        super(callback, RoomTextSearchMessageParser.class);
    }
}
