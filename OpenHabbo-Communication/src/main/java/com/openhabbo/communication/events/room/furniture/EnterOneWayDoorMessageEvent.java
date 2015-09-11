package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.EnterOneWayDoorMessageParser;

import java.util.function.Consumer;

public class EnterOneWayDoorMessageEvent extends AbstractMessageEvent<EnterOneWayDoorMessageParser> {

    public EnterOneWayDoorMessageEvent(Consumer<EnterOneWayDoorMessageParser> callback) {
        super(callback, EnterOneWayDoorMessageParser.class);
    }
}
