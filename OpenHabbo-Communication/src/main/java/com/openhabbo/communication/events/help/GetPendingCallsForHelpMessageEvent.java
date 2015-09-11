package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.GetPendingCallsForHelpMessageParser;

import java.util.function.Consumer;

public class GetPendingCallsForHelpMessageEvent extends AbstractMessageEvent<GetPendingCallsForHelpMessageParser> {

    public GetPendingCallsForHelpMessageEvent(Consumer<GetPendingCallsForHelpMessageParser> callback) {
        super(callback, GetPendingCallsForHelpMessageParser.class);
    }
}
