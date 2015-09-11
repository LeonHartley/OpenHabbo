package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.ConfirmDeclineTradingMessageParser;

import java.util.function.Consumer;

public class ConfirmDeclineTradingMessageEvent extends AbstractMessageEvent<ConfirmDeclineTradingMessageParser> {

    public ConfirmDeclineTradingMessageEvent(Consumer<ConfirmDeclineTradingMessageParser> callback) {
        super(callback, ConfirmDeclineTradingMessageParser.class);
    }
}
