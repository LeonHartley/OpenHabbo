package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.ThrowDiceMessageParser;

import java.util.function.Consumer;

public class ThrowDiceMessageEvent extends AbstractMessageEvent<ThrowDiceMessageParser> {

    public ThrowDiceMessageEvent(Consumer<ThrowDiceMessageParser> callback) {
        super(callback, ThrowDiceMessageParser.class);
    }
}
