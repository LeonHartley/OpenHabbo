package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.PickIssuesMessageParser;

import java.util.function.Consumer;

public class PickIssuesMessageEvent extends AbstractMessageEvent<PickIssuesMessageParser> {

    public PickIssuesMessageEvent(Consumer<PickIssuesMessageParser> callback) {
        super(callback, PickIssuesMessageParser.class);
    }
}
