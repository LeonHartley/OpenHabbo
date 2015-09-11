package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.CancelEventMessageParser;

import java.util.function.Consumer;

public class CancelEventMessageEvent extends AbstractMessageEvent<CancelEventMessageParser> {

    public CancelEventMessageEvent(Consumer<CancelEventMessageParser> callback) {
        super(callback, CancelEventMessageParser.class);
    }
}
