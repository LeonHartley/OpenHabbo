package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.GetOwnOffersMessageParser;

import java.util.function.Consumer;

public class GetOwnOffersMessageEvent extends AbstractMessageEvent<GetOwnOffersMessageParser> {

    public GetOwnOffersMessageEvent(Consumer<GetOwnOffersMessageParser> callback) {
        super(callback, GetOwnOffersMessageParser.class);
    }
}
