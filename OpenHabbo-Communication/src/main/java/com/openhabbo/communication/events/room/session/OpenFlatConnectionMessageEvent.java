package com.openhabbo.communication.events.room.session;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.session.OpenFlatConnectionMessageParser;

import java.util.function.Consumer;

public class OpenFlatConnectionMessageEvent extends AbstractMessageEvent<OpenFlatConnectionMessageParser> {

    public OpenFlatConnectionMessageEvent(Consumer<OpenFlatConnectionMessageParser> callback) {
        super(callback, OpenFlatConnectionMessageParser.class);
    }
}
