package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.AcceptTradingMessageParser;

import java.util.function.Consumer;

public class AcceptTradingMessageEvent extends AbstractMessageEvent<AcceptTradingMessageParser> {

    public AcceptTradingMessageEvent(Consumer<AcceptTradingMessageParser> callback) {
        super(callback, AcceptTradingMessageParser.class);
    }
}
