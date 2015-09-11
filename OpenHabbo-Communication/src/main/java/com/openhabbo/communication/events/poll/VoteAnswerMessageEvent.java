package com.openhabbo.communication.events.poll;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.poll.VoteAnswerMessageParser;

import java.util.function.Consumer;

public class VoteAnswerMessageEvent extends AbstractMessageEvent<VoteAnswerMessageParser> {

    public VoteAnswerMessageEvent(Consumer<VoteAnswerMessageParser> callback) {
        super(callback, VoteAnswerMessageParser.class);
    }
}
