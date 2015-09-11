package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.ApproveNameMessageParser;

import java.util.function.Consumer;

public class ApproveNameMessageEvent extends AbstractMessageEvent<ApproveNameMessageParser> {

    public ApproveNameMessageEvent(Consumer<ApproveNameMessageParser> callback) {
        super(callback, ApproveNameMessageParser.class);
    }
}
