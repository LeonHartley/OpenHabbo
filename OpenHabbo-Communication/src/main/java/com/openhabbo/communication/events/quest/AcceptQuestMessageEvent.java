package com.openhabbo.communication.events.quest;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.quest.AcceptQuestMessageParser;

import java.util.function.Consumer;

public class AcceptQuestMessageEvent extends AbstractMessageEvent<AcceptQuestMessageParser> {

    public AcceptQuestMessageEvent(Consumer<AcceptQuestMessageParser> callback) {
        super(callback, AcceptQuestMessageParser.class);
    }
}
