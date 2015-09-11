package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.IgnoreUserMessageParser;

import java.util.function.Consumer;

public class IgnoreUserMessageEvent extends AbstractMessageEvent<IgnoreUserMessageParser> {

    public IgnoreUserMessageEvent(Consumer<IgnoreUserMessageParser> callback) {
        super(callback, IgnoreUserMessageParser.class);
    }
}
