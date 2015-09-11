package com.openhabbo.communication.events.quest;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.quest.RejectQuestMessageParser;

import java.util.function.Consumer;

public class RejectQuestMessageEvent extends AbstractMessageEvent<RejectQuestMessageParser> {

    public RejectQuestMessageEvent(Consumer<RejectQuestMessageParser> callback) {
        super(callback, RejectQuestMessageParser.class);
    }
}
