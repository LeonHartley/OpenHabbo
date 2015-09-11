package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.GetMarketplaceConfigurationMessageParser;

import java.util.function.Consumer;

public class GetMarketplaceConfigurationMessageEvent extends AbstractMessageEvent<GetMarketplaceConfigurationMessageParser> {

    public GetMarketplaceConfigurationMessageEvent(Consumer<GetMarketplaceConfigurationMessageParser> callback) {
        super(callback, GetMarketplaceConfigurationMessageParser.class);
    }
}
