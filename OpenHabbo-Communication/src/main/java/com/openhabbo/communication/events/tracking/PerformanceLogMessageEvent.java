package com.openhabbo.communication.events.tracking;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.tracking.PerformanceLogMessageParser;

import java.util.function.Consumer;

public class PerformanceLogMessageEvent extends AbstractMessageEvent<PerformanceLogMessageParser> {

    public PerformanceLogMessageEvent(Consumer<PerformanceLogMessageParser> callback) {
        super(callback, PerformanceLogMessageParser.class);
    }
}
