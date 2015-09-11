package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.ConfirmAcceptTradingMessageParser;

import java.util.function.Consumer;

public class ConfirmAcceptTradingMessageEvent extends AbstractMessageEvent<ConfirmAcceptTradingMessageParser> {

    public ConfirmAcceptTradingMessageEvent(Consumer<ConfirmAcceptTradingMessageParser> callback) {
        super(callback, ConfirmAcceptTradingMessageParser.class);
    }
}
