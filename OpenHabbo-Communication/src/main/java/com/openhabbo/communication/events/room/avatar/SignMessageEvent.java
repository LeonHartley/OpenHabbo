package com.openhabbo.communication.events.room.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.avatar.SignMessageParser;

import java.util.function.Consumer;

public class SignMessageEvent extends AbstractMessageEvent<SignMessageParser> {

    public SignMessageEvent(Consumer<SignMessageParser> callback) {
        super(callback, SignMessageParser.class);
    }
}
