package com.openhabbo.communication.events.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.avatar.CheckUserNameMessageParser;

import java.util.function.Consumer;

public class CheckUserNameMessageEvent extends AbstractMessageEvent<CheckUserNameMessageParser> {

    public CheckUserNameMessageEvent(Consumer<CheckUserNameMessageParser> callback) {
        super(callback, CheckUserNameMessageParser.class);
    }
}
