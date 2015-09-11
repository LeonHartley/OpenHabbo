package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.BuyOfferMessageParser;

import java.util.function.Consumer;

public class BuyOfferMessageEvent extends AbstractMessageEvent<BuyOfferMessageParser> {

    public BuyOfferMessageEvent(Consumer<BuyOfferMessageParser> callback) {
        super(callback, BuyOfferMessageParser.class);
    }
}
