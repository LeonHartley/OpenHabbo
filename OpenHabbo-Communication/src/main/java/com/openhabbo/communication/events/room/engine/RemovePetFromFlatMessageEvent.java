package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.RemovePetFromFlatMessageParser;

import java.util.function.Consumer;

public class RemovePetFromFlatMessageEvent extends AbstractMessageEvent<RemovePetFromFlatMessageParser> {

    public RemovePetFromFlatMessageEvent(Consumer<RemovePetFromFlatMessageParser> callback) {
        super(callback, RemovePetFromFlatMessageParser.class);
    }
}
