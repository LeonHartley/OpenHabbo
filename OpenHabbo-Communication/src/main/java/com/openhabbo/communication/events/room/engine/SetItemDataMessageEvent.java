package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.SetItemDataMessageParser;

import java.util.function.Consumer;

public class SetItemDataMessageEvent extends AbstractMessageEvent<SetItemDataMessageParser> {

    public SetItemDataMessageEvent(Consumer<SetItemDataMessageParser> callback) {
        super(callback, SetItemDataMessageParser.class);
    }
}
