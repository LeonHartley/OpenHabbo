package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.SetRandomStateMessageParser;

import java.util.function.Consumer;

public class SetRandomStateMessageEvent extends AbstractMessageEvent<SetRandomStateMessageParser> {

    public SetRandomStateMessageEvent(Consumer<SetRandomStateMessageParser> callback) {
        super(callback, SetRandomStateMessageParser.class);
    }
}
