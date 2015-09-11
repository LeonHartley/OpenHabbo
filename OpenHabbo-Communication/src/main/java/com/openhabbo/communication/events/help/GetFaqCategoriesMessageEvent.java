package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.GetFaqCategoriesMessageParser;

import java.util.function.Consumer;

public class GetFaqCategoriesMessageEvent extends AbstractMessageEvent<GetFaqCategoriesMessageParser> {

    public GetFaqCategoriesMessageEvent(Consumer<GetFaqCategoriesMessageParser> callback) {
        super(callback, GetFaqCategoriesMessageParser.class);
    }
}
