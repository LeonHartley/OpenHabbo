package com.openhabbo.communication.events.help;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.help.DeletePendingCallsForHelpMessageParser;

import java.util.function.Consumer;

public class DeletePendingCallsForHelpMessageEvent extends AbstractMessageEvent<DeletePendingCallsForHelpMessageParser> {

    public DeletePendingCallsForHelpMessageEvent(Consumer<DeletePendingCallsForHelpMessageParser> callback) {
        super(callback, DeletePendingCallsForHelpMessageParser.class);
    }
}
