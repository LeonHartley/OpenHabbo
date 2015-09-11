package com.openhabbo.communication.events.room.pets;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.pets.RespectPetMessageParser;

import java.util.function.Consumer;

public class RespectPetMessageEvent extends AbstractMessageEvent<RespectPetMessageParser> {

    public RespectPetMessageEvent(Consumer<RespectPetMessageParser> callback) {
        super(callback, RespectPetMessageParser.class);
    }
}
