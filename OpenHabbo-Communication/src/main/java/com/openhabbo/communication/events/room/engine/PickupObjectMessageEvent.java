package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.PickupObjectMessageParser;

import java.util.function.Consumer;

public class PickupObjectMessageEvent extends AbstractMessageEvent<PickupObjectMessageParser> {

    public PickupObjectMessageEvent(Consumer<PickupObjectMessageParser> callback) {
        super(callback, PickupObjectMessageParser.class);
    }
}
