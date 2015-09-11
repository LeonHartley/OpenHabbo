package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.GetOffersMessageParser;

import java.util.function.Consumer;

public class GetOffersMessageEvent extends AbstractMessageEvent<GetOffersMessageParser> {

    public GetOffersMessageEvent(Consumer<GetOffersMessageParser> callback) {
        super(callback, GetOffersMessageParser.class);
    }
}
