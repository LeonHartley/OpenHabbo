package com.openhabbo.communication.events.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.avatar.ChangeUserNameMessageParser;

import java.util.function.Consumer;

public class ChangeUserNameMessageEvent extends AbstractMessageEvent<ChangeUserNameMessageParser> {

    public ChangeUserNameMessageEvent(Consumer<ChangeUserNameMessageParser> callback) {
        super(callback, ChangeUserNameMessageParser.class);
    }
}
