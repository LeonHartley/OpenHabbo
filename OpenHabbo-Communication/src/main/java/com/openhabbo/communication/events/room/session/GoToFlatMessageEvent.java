package com.openhabbo.communication.events.room.session;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.session.GoToFlatMessageParser;

import java.util.function.Consumer;

public class GoToFlatMessageEvent extends AbstractMessageEvent<GoToFlatMessageParser> {

    public GoToFlatMessageEvent(Consumer<GoToFlatMessageParser> callback) {
        super(callback, GoToFlatMessageParser.class);
    }
}
