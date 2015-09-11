package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.UnignoreUserMessageParser;

import java.util.function.Consumer;

public class UnignoreUserMessageEvent extends AbstractMessageEvent<UnignoreUserMessageParser> {

    public UnignoreUserMessageEvent(Consumer<UnignoreUserMessageParser> callback) {
        super(callback, UnignoreUserMessageParser.class);
    }
}
