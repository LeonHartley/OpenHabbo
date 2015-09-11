package com.openhabbo.communication.events.tracking;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.tracking.LatencyPingRequestMessageParser;

import java.util.function.Consumer;

public class LatencyPingRequestMessageEvent extends AbstractMessageEvent<LatencyPingRequestMessageParser> {

    public LatencyPingRequestMessageEvent(Consumer<LatencyPingRequestMessageParser> callback) {
        super(callback, LatencyPingRequestMessageParser.class);
    }
}
