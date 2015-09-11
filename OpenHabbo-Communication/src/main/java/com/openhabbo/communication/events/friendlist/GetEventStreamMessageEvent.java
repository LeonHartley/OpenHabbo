package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.GetEventStreamMessageParser;

import java.util.function.Consumer;

public class GetEventStreamMessageEvent extends AbstractMessageEvent<GetEventStreamMessageParser> {

    public GetEventStreamMessageEvent(Consumer<GetEventStreamMessageParser> callback) {
        super(callback, GetEventStreamMessageParser.class);
    }
}
