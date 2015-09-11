package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.RedeemVoucherMessageParser;

import java.util.function.Consumer;

public class RedeemVoucherMessageEvent extends AbstractMessageEvent<RedeemVoucherMessageParser> {

    public RedeemVoucherMessageEvent(Consumer<RedeemVoucherMessageParser> callback) {
        super(callback, RedeemVoucherMessageParser.class);
    }
}
