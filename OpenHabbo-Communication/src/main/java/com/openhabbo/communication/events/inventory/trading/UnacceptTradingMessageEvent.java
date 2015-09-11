package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.UnacceptTradingMessageParser;

import java.util.function.Consumer;

public class UnacceptTradingMessageEvent extends AbstractMessageEvent<UnacceptTradingMessageParser> {

    public UnacceptTradingMessageEvent(Consumer<UnacceptTradingMessageParser> callback) {
        super(callback, UnacceptTradingMessageParser.class);
    }
}
