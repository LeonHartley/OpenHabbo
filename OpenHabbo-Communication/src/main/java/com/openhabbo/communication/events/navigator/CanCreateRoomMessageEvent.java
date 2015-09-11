package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.CanCreateRoomMessageParser;

import java.util.function.Consumer;

public class CanCreateRoomMessageEvent extends AbstractMessageEvent<CanCreateRoomMessageParser> {

    public CanCreateRoomMessageEvent(Consumer<CanCreateRoomMessageParser> callback) {
        super(callback, CanCreateRoomMessageParser.class);
    }
}
