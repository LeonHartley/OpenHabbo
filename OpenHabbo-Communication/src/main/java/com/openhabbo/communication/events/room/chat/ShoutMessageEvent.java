package com.openhabbo.communication.events.room.chat;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.chat.ShoutMessageParser;

import java.util.function.Consumer;

public class ShoutMessageEvent extends AbstractMessageEvent<ShoutMessageParser> {

    public ShoutMessageEvent(Consumer<ShoutMessageParser> callback) {
        super(callback, ShoutMessageParser.class);
    }
}
