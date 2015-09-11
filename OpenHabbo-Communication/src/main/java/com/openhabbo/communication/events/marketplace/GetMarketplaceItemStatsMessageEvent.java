package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.GetMarketplaceItemStatsMessageParser;

import java.util.function.Consumer;

public class GetMarketplaceItemStatsMessageEvent extends AbstractMessageEvent<GetMarketplaceItemStatsMessageParser> {

    public GetMarketplaceItemStatsMessageEvent(Consumer<GetMarketplaceItemStatsMessageParser> callback) {
        super(callback, GetMarketplaceItemStatsMessageParser.class);
    }
}
