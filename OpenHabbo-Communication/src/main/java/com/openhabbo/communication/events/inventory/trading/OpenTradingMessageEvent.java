package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.OpenTradingMessageParser;

import java.util.function.Consumer;

public class OpenTradingMessageEvent extends AbstractMessageEvent<OpenTradingMessageParser> {

    public OpenTradingMessageEvent(Consumer<OpenTradingMessageParser> callback) {
        super(callback, OpenTradingMessageParser.class);
    }
}
