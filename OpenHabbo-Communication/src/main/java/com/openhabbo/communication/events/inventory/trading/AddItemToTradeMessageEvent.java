package com.openhabbo.communication.events.inventory.trading;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.trading.AddItemToTradeMessageParser;

import java.util.function.Consumer;

public class AddItemToTradeMessageEvent extends AbstractMessageEvent<AddItemToTradeMessageParser> {

    public AddItemToTradeMessageEvent(Consumer<AddItemToTradeMessageParser> callback) {
        super(callback, AddItemToTradeMessageParser.class);
    }
}
