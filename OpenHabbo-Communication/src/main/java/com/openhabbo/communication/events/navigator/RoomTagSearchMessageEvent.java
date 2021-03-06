package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.RoomTagSearchMessageParser;

import java.util.function.Consumer;

public class RoomTagSearchMessageEvent extends AbstractMessageEvent<RoomTagSearchMessageParser> {

    public RoomTagSearchMessageEvent(Consumer<RoomTagSearchMessageParser> callback) {
        super(callback, RoomTagSearchMessageParser.class);
    }
}
