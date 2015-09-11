package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.GetMarketplaceCanMakeOfferMessageParser;

import java.util.function.Consumer;

public class GetMarketplaceCanMakeOfferMessageEvent extends AbstractMessageEvent<GetMarketplaceCanMakeOfferMessageParser> {

    public GetMarketplaceCanMakeOfferMessageEvent(Consumer<GetMarketplaceCanMakeOfferMessageParser> callback) {
        super(callback, GetMarketplaceCanMakeOfferMessageParser.class);
    }
}
