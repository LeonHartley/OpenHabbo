package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.PurchaseVipMembershipExtensionMessageParser;

import java.util.function.Consumer;

public class PurchaseVipMembershipExtensionMessageEvent extends AbstractMessageEvent<PurchaseVipMembershipExtensionMessageParser> {

    public PurchaseVipMembershipExtensionMessageEvent(Consumer<PurchaseVipMembershipExtensionMessageParser> callback) {
        super(callback, PurchaseVipMembershipExtensionMessageParser.class);
    }
}
