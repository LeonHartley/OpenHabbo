package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.SpinWheelOfFortuneMessageParser;

import java.util.function.Consumer;

public class SpinWheelOfFortuneMessageEvent extends AbstractMessageEvent<SpinWheelOfFortuneMessageParser> {

    public SpinWheelOfFortuneMessageEvent(Consumer<SpinWheelOfFortuneMessageParser> callback) {
        super(callback, SpinWheelOfFortuneMessageParser.class);
    }
}
