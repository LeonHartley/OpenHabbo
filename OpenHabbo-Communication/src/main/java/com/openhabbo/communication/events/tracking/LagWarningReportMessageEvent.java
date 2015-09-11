package com.openhabbo.communication.events.tracking;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.tracking.LagWarningReportMessageParser;

import java.util.function.Consumer;

public class LagWarningReportMessageEvent extends AbstractMessageEvent<LagWarningReportMessageParser> {

    public LagWarningReportMessageEvent(Consumer<LagWarningReportMessageParser> callback) {
        super(callback, LagWarningReportMessageParser.class);
    }
}
