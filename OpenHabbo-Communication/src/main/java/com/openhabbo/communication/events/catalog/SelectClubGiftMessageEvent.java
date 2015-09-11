package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.SelectClubGiftMessageParser;

import java.util.function.Consumer;

public class SelectClubGiftMessageEvent extends AbstractMessageEvent<SelectClubGiftMessageParser> {

    public SelectClubGiftMessageEvent(Consumer<SelectClubGiftMessageParser> callback) {
        super(callback, SelectClubGiftMessageParser.class);
    }
}
