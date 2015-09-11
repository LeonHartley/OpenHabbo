package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.RemoveAllRightsMessageParser;

import java.util.function.Consumer;

public class RemoveAllRightsMessageEvent extends AbstractMessageEvent<RemoveAllRightsMessageParser> {

    public RemoveAllRightsMessageEvent(Consumer<RemoveAllRightsMessageParser> callback) {
        super(callback, RemoveAllRightsMessageParser.class);
    }
}
