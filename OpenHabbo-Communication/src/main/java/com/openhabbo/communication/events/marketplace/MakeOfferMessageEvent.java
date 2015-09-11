package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.MakeOfferMessageParser;

import java.util.function.Consumer;

public class MakeOfferMessageEvent extends AbstractMessageEvent<MakeOfferMessageParser> {

    public MakeOfferMessageEvent(Consumer<MakeOfferMessageParser> callback) {
        super(callback, MakeOfferMessageParser.class);
    }
}
