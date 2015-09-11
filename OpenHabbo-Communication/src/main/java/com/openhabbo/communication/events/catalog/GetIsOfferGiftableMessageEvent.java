package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetIsOfferGiftableMessageParser;

import java.util.function.Consumer;

public class GetIsOfferGiftableMessageEvent extends AbstractMessageEvent<GetIsOfferGiftableMessageParser> {

    public GetIsOfferGiftableMessageEvent(Consumer<GetIsOfferGiftableMessageParser> callback) {
        super(callback, GetIsOfferGiftableMessageParser.class);
    }
}
