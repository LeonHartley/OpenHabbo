package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.GetClientFaqsMessageParser;

import java.util.function.Consumer;

public class GetClientFaqsMessageEvent extends AbstractMessageEvent<GetClientFaqsMessageParser> {

    public GetClientFaqsMessageEvent(Consumer<GetClientFaqsMessageParser> callback) {
        super(callback, GetClientFaqsMessageParser.class);
    }
}
