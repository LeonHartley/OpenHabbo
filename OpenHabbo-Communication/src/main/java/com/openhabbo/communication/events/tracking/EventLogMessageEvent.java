package com.openhabbo.communication.events.tracking;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.tracking.EventLogMessageParser;

import java.util.function.Consumer;

public class EventLogMessageEvent extends AbstractMessageEvent<EventLogMessageParser> {

    public EventLogMessageEvent(Consumer<EventLogMessageParser> callback) {
        super(callback, EventLogMessageParser.class);
    }
}
