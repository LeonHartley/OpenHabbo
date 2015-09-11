package com.openhabbo.communication.events.inventory.purse;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.purse.GetCreditsInfoMessageParser;

import java.util.function.Consumer;

public class GetCreditsInfoMessageEvent extends AbstractMessageEvent<GetCreditsInfoMessageParser> {

    public GetCreditsInfoMessageEvent(Consumer<GetCreditsInfoMessageParser> callback) {
        super(callback, GetCreditsInfoMessageParser.class);
    }
}
