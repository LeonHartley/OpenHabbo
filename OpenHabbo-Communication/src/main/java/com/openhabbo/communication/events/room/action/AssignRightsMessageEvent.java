package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.AssignRightsMessageParser;

import java.util.function.Consumer;

public class AssignRightsMessageEvent extends AbstractMessageEvent<AssignRightsMessageParser> {

    public AssignRightsMessageEvent(Consumer<AssignRightsMessageParser> callback) {
        super(callback, AssignRightsMessageParser.class);
    }
}
