package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.ReleaseIssuesMessageParser;

import java.util.function.Consumer;

public class ReleaseIssuesMessageEvent extends AbstractMessageEvent<ReleaseIssuesMessageParser> {

    public ReleaseIssuesMessageEvent(Consumer<ReleaseIssuesMessageParser> callback) {
        super(callback, ReleaseIssuesMessageParser.class);
    }
}
