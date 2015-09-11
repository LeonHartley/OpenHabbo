package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetSellablePetBreedsMessageParser;

import java.util.function.Consumer;

public class GetSellablePetBreedsMessageEvent extends AbstractMessageEvent<GetSellablePetBreedsMessageParser> {

    public GetSellablePetBreedsMessageEvent(Consumer<GetSellablePetBreedsMessageParser> callback) {
        super(callback, GetSellablePetBreedsMessageParser.class);
    }
}
