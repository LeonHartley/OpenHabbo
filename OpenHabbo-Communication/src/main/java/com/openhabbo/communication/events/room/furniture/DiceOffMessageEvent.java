package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.DiceOffMessageParser;

import java.util.function.Consumer;

public class DiceOffMessageEvent extends AbstractMessageEvent<DiceOffMessageParser> {

    public DiceOffMessageEvent(Consumer<DiceOffMessageParser> callback) {
        super(callback, DiceOffMessageParser.class);
    }
}
