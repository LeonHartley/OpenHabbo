package com.openhabbo.communication.events.room.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.avatar.LookToMessageParser;

import java.util.function.Consumer;

public class LookToMessageEvent extends AbstractMessageEvent<LookToMessageParser> {

    public LookToMessageEvent(Consumer<LookToMessageParser> callback) {
        super(callback, LookToMessageParser.class);
    }
}
