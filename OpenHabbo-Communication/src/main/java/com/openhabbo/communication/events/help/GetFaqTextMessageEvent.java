package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.GetFaqTextMessageParser;

import java.util.function.Consumer;

public class GetFaqTextMessageEvent extends AbstractMessageEvent<GetFaqTextMessageParser> {

    public GetFaqTextMessageEvent(Consumer<GetFaqTextMessageParser> callback) {
        super(callback, GetFaqTextMessageParser.class);
    }
}
