package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.GetFaqCategoryMessageParser;

import java.util.function.Consumer;

public class GetFaqCategoryMessageEvent extends AbstractMessageEvent<GetFaqCategoryMessageParser> {

    public GetFaqCategoryMessageEvent(Consumer<GetFaqCategoryMessageParser> callback) {
        super(callback, GetFaqCategoryMessageParser.class);
    }
}
