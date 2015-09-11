package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.ScrGetUserInfoMessageParser;

import java.util.function.Consumer;

public class ScrGetUserInfoMessageEvent extends AbstractMessageEvent<ScrGetUserInfoMessageParser> {

    public ScrGetUserInfoMessageEvent(Consumer<ScrGetUserInfoMessageParser> callback) {
        super(callback, ScrGetUserInfoMessageParser.class);
    }
}
