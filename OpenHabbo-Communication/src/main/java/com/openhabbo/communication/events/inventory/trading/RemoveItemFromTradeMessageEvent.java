package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.RemoveItemFromTradeMessageParser;

import java.util.function.Consumer;

public class RemoveItemFromTradeMessageEvent extends AbstractMessageEvent<RemoveItemFromTradeMessageParser> {

    public RemoveItemFromTradeMessageEvent(Consumer<RemoveItemFromTradeMessageParser> callback) {
        super(callback, RemoveItemFromTradeMessageParser.class);
    }
}
