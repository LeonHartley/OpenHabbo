package com.openhabbo.communication.events.room.session;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.session.ChangeQueueMessageParser;

import java.util.function.Consumer;

public class ChangeQueueMessageEvent extends AbstractMessageEvent<ChangeQueueMessageParser> {

    public ChangeQueueMessageEvent(Consumer<ChangeQueueMessageParser> callback) {
        super(callback, ChangeQueueMessageParser.class);
    }
}
