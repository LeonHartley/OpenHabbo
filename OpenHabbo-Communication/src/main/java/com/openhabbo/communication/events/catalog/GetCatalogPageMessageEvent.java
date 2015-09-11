package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetCatalogPageMessageParser;

import java.util.function.Consumer;

public class GetCatalogPageMessageEvent extends AbstractMessageEvent<GetCatalogPageMessageParser> {

    public GetCatalogPageMessageEvent(Consumer<GetCatalogPageMessageParser> callback) {
        super(callback, GetCatalogPageMessageParser.class);
    }
}
