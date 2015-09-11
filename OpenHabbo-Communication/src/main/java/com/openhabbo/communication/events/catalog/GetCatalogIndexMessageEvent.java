package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetCatalogIndexMessageParser;

import java.util.function.Consumer;

public class GetCatalogIndexMessageEvent extends AbstractMessageEvent<GetCatalogIndexMessageParser> {

    public GetCatalogIndexMessageEvent(Consumer<GetCatalogIndexMessageParser> callback) {
        super(callback, GetCatalogIndexMessageParser.class);
    }
}
