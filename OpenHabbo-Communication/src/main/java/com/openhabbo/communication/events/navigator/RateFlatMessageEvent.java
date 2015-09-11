package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.RateFlatMessageParser;

import java.util.function.Consumer;

public class RateFlatMessageEvent extends AbstractMessageEvent<RateFlatMessageParser> {

    public RateFlatMessageEvent(Consumer<RateFlatMessageParser> callback) {
        super(callback, RateFlatMessageParser.class);
    }
}
