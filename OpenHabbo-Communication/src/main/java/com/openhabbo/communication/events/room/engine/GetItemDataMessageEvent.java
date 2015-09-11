package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.GetItemDataMessageParser;

import java.util.function.Consumer;

public class GetItemDataMessageEvent extends AbstractMessageEvent<GetItemDataMessageParser> {

    public GetItemDataMessageEvent(Consumer<GetItemDataMessageParser> callback) {
        super(callback, GetItemDataMessageParser.class);
    }
}
