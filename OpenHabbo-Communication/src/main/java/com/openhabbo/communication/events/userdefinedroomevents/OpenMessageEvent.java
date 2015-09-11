package com.openhabbo.communication.events.userdefinedroomevents;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.userdefinedroomevents.OpenMessageParser;

import java.util.function.Consumer;

public class OpenMessageEvent extends AbstractMessageEvent<OpenMessageParser> {

    public OpenMessageEvent(Consumer<OpenMessageParser> callback) {
        super(callback, OpenMessageParser.class);
    }
}
