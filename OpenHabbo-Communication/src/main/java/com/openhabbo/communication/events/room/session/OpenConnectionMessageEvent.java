package com.openhabbo.communication.events.room.session;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.session.OpenConnectionMessageParser;

import java.util.function.Consumer;

public class OpenConnectionMessageEvent extends AbstractMessageEvent<OpenConnectionMessageParser> {

    public OpenConnectionMessageEvent(Consumer<OpenConnectionMessageParser> callback) {
        super(callback, OpenConnectionMessageParser.class);
    }
}
