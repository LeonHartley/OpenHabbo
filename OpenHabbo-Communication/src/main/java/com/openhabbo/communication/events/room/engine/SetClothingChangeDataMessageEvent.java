package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.SetClothingChangeDataMessageParser;

import java.util.function.Consumer;

public class SetClothingChangeDataMessageEvent extends AbstractMessageEvent<SetClothingChangeDataMessageParser> {

    public SetClothingChangeDataMessageEvent(Consumer<SetClothingChangeDataMessageParser> callback) {
        super(callback, SetClothingChangeDataMessageParser.class);
    }
}
