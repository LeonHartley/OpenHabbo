package com.openhabbo.communication.events.tracking;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.tracking.LatencyPingReportMessageParser;

import java.util.function.Consumer;

public class LatencyPingReportMessageEvent extends AbstractMessageEvent<LatencyPingReportMessageParser> {

    public LatencyPingReportMessageEvent(Consumer<LatencyPingReportMessageParser> callback) {
        super(callback, LatencyPingReportMessageParser.class);
    }
}
