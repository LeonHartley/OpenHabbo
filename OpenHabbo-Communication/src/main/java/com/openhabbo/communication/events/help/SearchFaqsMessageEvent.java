package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.SearchFaqsMessageParser;

import java.util.function.Consumer;

public class SearchFaqsMessageEvent extends AbstractMessageEvent<SearchFaqsMessageParser> {

    public SearchFaqsMessageEvent(Consumer<SearchFaqsMessageParser> callback) {
        super(callback, SearchFaqsMessageParser.class);
    }
}
