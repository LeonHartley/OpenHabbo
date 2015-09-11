package com.openhabbo.communication.events.inventory.pets;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.pets.GetPetInventoryMessageParser;

import java.util.function.Consumer;

public class GetPetInventoryMessageEvent extends AbstractMessageEvent<GetPetInventoryMessageParser> {

    public GetPetInventoryMessageEvent(Consumer<GetPetInventoryMessageParser> callback) {
        super(callback, GetPetInventoryMessageParser.class);
    }
}
