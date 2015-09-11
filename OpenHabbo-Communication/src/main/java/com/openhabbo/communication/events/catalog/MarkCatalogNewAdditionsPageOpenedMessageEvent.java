package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.MarkCatalogNewAdditionsPageOpenedMessageParser;

import java.util.function.Consumer;

public class MarkCatalogNewAdditionsPageOpenedMessageEvent extends AbstractMessageEvent<MarkCatalogNewAdditionsPageOpenedMessageParser> {

    public MarkCatalogNewAdditionsPageOpenedMessageEvent(Consumer<MarkCatalogNewAdditionsPageOpenedMessageParser> callback) {
        super(callback, MarkCatalogNewAdditionsPageOpenedMessageParser.class);
    }
}
