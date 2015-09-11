package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.CreateFlatMessageParser;

import java.util.function.Consumer;

public class CreateFlatMessageEvent extends AbstractMessageEvent<CreateFlatMessageParser> {

    public CreateFlatMessageEvent(Consumer<CreateFlatMessageParser> callback) {
        super(callback, CreateFlatMessageParser.class);
    }
}
