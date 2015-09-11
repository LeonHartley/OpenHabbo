package com.openhabbo.communication.events.poll;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.poll.PollRejectMessageParser;

import java.util.function.Consumer;

public class PollRejectMessageEvent extends AbstractMessageEvent<PollRejectMessageParser> {

    public PollRejectMessageEvent(Consumer<PollRejectMessageParser> callback) {
        super(callback, PollRejectMessageParser.class);
    }
}
