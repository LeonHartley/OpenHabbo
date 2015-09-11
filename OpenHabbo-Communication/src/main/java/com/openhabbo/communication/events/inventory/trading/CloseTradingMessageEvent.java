package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.CloseTradingMessageParser;

import java.util.function.Consumer;

public class CloseTradingMessageEvent extends AbstractMessageEvent<CloseTradingMessageParser> {

    public CloseTradingMessageEvent(Consumer<CloseTradingMessageParser> callback) {
        super(callback, CloseTradingMessageParser.class);
    }
}
