package com.openhabbo.communication.events.quest;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.quest.OpenQuestTrackerMessageParser;

import java.util.function.Consumer;

public class OpenQuestTrackerMessageEvent extends AbstractMessageEvent<OpenQuestTrackerMessageParser> {

    public OpenQuestTrackerMessageEvent(Consumer<OpenQuestTrackerMessageParser> callback) {
        super(callback, OpenQuestTrackerMessageParser.class);
    }
}
