package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.CancelOfferMessageParser;

import java.util.function.Consumer;

public class CancelOfferMessageEvent extends AbstractMessageEvent<CancelOfferMessageParser> {

    public CancelOfferMessageEvent(Consumer<CancelOfferMessageParser> callback) {
        super(callback, CancelOfferMessageParser.class);
    }
}
