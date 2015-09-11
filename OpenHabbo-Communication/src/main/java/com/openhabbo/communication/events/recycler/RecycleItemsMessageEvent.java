package com.openhabbo.communication.events.recycler;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.recycler.RecycleItemsMessageParser;

import java.util.function.Consumer;

public class RecycleItemsMessageEvent extends AbstractMessageEvent<RecycleItemsMessageParser> {

    public RecycleItemsMessageEvent(Consumer<RecycleItemsMessageParser> callback) {
        super(callback, RecycleItemsMessageParser.class);
    }
}
