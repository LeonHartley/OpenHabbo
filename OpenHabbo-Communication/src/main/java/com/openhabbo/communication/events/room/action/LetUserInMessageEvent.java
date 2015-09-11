package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.LetUserInMessageParser;

import java.util.function.Consumer;

public class LetUserInMessageEvent extends AbstractMessageEvent<LetUserInMessageParser> {

    public LetUserInMessageEvent(Consumer<LetUserInMessageParser> callback) {
        super(callback, LetUserInMessageParser.class);
    }
}
