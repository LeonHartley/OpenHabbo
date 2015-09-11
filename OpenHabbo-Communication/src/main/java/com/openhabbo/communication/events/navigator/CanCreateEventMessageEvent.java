package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.CanCreateEventMessageParser;

import java.util.function.Consumer;

public class CanCreateEventMessageEvent extends AbstractMessageEvent<CanCreateEventMessageParser> {

    public CanCreateEventMessageEvent(Consumer<CanCreateEventMessageParser> callback) {
        super(callback, CanCreateEventMessageParser.class);
    }
}
