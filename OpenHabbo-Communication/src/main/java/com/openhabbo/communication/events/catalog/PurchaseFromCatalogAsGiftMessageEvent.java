package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.PurchaseFromCatalogAsGiftMessageParser;

import java.util.function.Consumer;

public class PurchaseFromCatalogAsGiftMessageEvent extends AbstractMessageEvent<PurchaseFromCatalogAsGiftMessageParser> {

    public PurchaseFromCatalogAsGiftMessageEvent(Consumer<PurchaseFromCatalogAsGiftMessageParser> callback) {
        super(callback, PurchaseFromCatalogAsGiftMessageParser.class);
    }
}
