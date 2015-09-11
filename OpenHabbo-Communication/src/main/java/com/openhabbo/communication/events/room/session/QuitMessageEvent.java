package com.openhabbo.communication.events.room.session;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.session.QuitMessageParser;

import java.util.function.Consumer;

public class QuitMessageEvent extends AbstractMessageEvent<QuitMessageParser> {

    public QuitMessageEvent(Consumer<QuitMessageParser> callback) {
        super(callback, QuitMessageParser.class);
    }
}
