package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.RemoveRightsMessageParser;

import java.util.function.Consumer;

public class RemoveRightsMessageEvent extends AbstractMessageEvent<RemoveRightsMessageParser> {

    public RemoveRightsMessageEvent(Consumer<RemoveRightsMessageParser> callback) {
        super(callback, RemoveRightsMessageParser.class);
    }
}
