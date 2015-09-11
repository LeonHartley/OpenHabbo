package com.openhabbo.communication.events.poll;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.poll.PollStartMessageParser;

import java.util.function.Consumer;

public class PollStartMessageEvent extends AbstractMessageEvent<PollStartMessageParser> {

    public PollStartMessageEvent(Consumer<PollStartMessageParser> callback) {
        super(callback, PollStartMessageParser.class);
    }
}
