package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.SetObjectDataMessageParser;

import java.util.function.Consumer;

public class SetObjectDataMessageEvent extends AbstractMessageEvent<SetObjectDataMessageParser> {

    public SetObjectDataMessageEvent(Consumer<SetObjectDataMessageParser> callback) {
        super(callback, SetObjectDataMessageParser.class);
    }
}
