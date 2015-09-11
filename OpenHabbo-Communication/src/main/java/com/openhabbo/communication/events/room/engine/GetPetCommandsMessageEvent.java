package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.GetPetCommandsMessageParser;

import java.util.function.Consumer;

public class GetPetCommandsMessageEvent extends AbstractMessageEvent<GetPetCommandsMessageParser> {

    public GetPetCommandsMessageEvent(Consumer<GetPetCommandsMessageParser> callback) {
        super(callback, GetPetCommandsMessageParser.class);
    }
}
