package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.PurchaseFromCatalogMessageParser;

import java.util.function.Consumer;

public class PurchaseFromCatalogMessageEvent extends AbstractMessageEvent<PurchaseFromCatalogMessageParser> {

    public PurchaseFromCatalogMessageEvent(Consumer<PurchaseFromCatalogMessageParser> callback) {
        super(callback, PurchaseFromCatalogMessageParser.class);
    }
}
