package com.openhabbo.communication.events.poll;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.poll.PollAnswerMessageParser;

import java.util.function.Consumer;

public class PollAnswerMessageEvent extends AbstractMessageEvent<PollAnswerMessageParser> {

    public PollAnswerMessageEvent(Consumer<PollAnswerMessageParser> callback) {
        super(callback, PollAnswerMessageParser.class);
    }
}
