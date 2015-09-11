package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.PurchaseBasicMembershipExtensionMessageParser;

import java.util.function.Consumer;

public class PurchaseBasicMembershipExtensionMessageEvent extends AbstractMessageEvent<PurchaseBasicMembershipExtensionMessageParser> {

    public PurchaseBasicMembershipExtensionMessageEvent(Consumer<PurchaseBasicMembershipExtensionMessageParser> callback) {
        super(callback, PurchaseBasicMembershipExtensionMessageParser.class);
    }
}
