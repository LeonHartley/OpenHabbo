package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.CallGuideBotMessageParser;

import java.util.function.Consumer;

public class CallGuideBotMessageEvent extends AbstractMessageEvent<CallGuideBotMessageParser> {

    public CallGuideBotMessageEvent(Consumer<CallGuideBotMessageParser> callback) {
        super(callback, CallGuideBotMessageParser.class);
    }
}
