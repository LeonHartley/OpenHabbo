package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.RespectUserMessageParser;

import java.util.function.Consumer;

public class RespectUserMessageEvent extends AbstractMessageEvent<RespectUserMessageParser> {

    public RespectUserMessageEvent(Consumer<RespectUserMessageParser> callback) {
        super(callback, RespectUserMessageParser.class);
    }
}
