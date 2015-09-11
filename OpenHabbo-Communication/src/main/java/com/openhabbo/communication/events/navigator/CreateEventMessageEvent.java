package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.CreateEventMessageParser;

import java.util.function.Consumer;

public class CreateEventMessageEvent extends AbstractMessageEvent<CreateEventMessageParser> {

    public CreateEventMessageEvent(Consumer<CreateEventMessageParser> callback) {
        super(callback, CreateEventMessageParser.class);
    }
}
