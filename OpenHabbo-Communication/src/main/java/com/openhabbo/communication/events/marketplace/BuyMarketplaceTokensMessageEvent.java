package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.BuyMarketplaceTokensMessageParser;

import java.util.function.Consumer;

public class BuyMarketplaceTokensMessageEvent extends AbstractMessageEvent<BuyMarketplaceTokensMessageParser> {

    public BuyMarketplaceTokensMessageEvent(Consumer<BuyMarketplaceTokensMessageParser> callback) {
        super(callback, BuyMarketplaceTokensMessageParser.class);
    }
}
