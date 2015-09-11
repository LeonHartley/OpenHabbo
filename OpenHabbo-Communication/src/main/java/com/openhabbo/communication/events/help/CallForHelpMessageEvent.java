package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.CallForHelpMessageParser;

import java.util.function.Consumer;

public class CallForHelpMessageEvent extends AbstractMessageEvent<CallForHelpMessageParser> {

    public CallForHelpMessageEvent(Consumer<CallForHelpMessageParser> callback) {
        super(callback, CallForHelpMessageParser.class);
    }
}
