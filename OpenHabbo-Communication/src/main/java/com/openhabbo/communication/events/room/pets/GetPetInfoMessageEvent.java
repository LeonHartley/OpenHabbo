package com.openhabbo.communication.events.room.pets;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.pets.GetPetInfoMessageParser;

import java.util.function.Consumer;

public class GetPetInfoMessageEvent extends AbstractMessageEvent<GetPetInfoMessageParser> {

    public GetPetInfoMessageEvent(Consumer<GetPetInfoMessageParser> callback) {
        super(callback, GetPetInfoMessageParser.class);
    }
}
