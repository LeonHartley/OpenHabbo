package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.EditEventMessageParser;

import java.util.function.Consumer;

public class EditEventMessageEvent extends AbstractMessageEvent<EditEventMessageParser> {

    public EditEventMessageEvent(Consumer<EditEventMessageParser> callback) {
        super(callback, EditEventMessageParser.class);
    }
}
