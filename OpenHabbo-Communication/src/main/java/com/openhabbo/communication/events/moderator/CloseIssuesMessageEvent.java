package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.CloseIssuesMessageParser;

import java.util.function.Consumer;

public class CloseIssuesMessageEvent extends AbstractMessageEvent<CloseIssuesMessageParser> {

    public CloseIssuesMessageEvent(Consumer<CloseIssuesMessageParser> callback) {
        super(callback, CloseIssuesMessageParser.class);
    }
}
