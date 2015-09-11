package com.openhabbo.communication.events.quest;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.quest.GetQuestsMessageParser;

import java.util.function.Consumer;

public class GetQuestsMessageEvent extends AbstractMessageEvent<GetQuestsMessageParser> {

    public GetQuestsMessageEvent(Consumer<GetQuestsMessageParser> callback) {
        super(callback, GetQuestsMessageParser.class);
    }
}
