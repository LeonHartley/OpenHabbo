package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.ChangeEmailMessageParser;

import java.util.function.Consumer;

public class ChangeEmailMessageEvent extends AbstractMessageEvent<ChangeEmailMessageParser> {

    public ChangeEmailMessageEvent(Consumer<ChangeEmailMessageParser> callback) {
        super(callback, ChangeEmailMessageParser.class);
    }
}
