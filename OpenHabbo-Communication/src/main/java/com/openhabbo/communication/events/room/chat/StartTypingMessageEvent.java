package com.openhabbo.communication.events.room.chat;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.chat.StartTypingMessageParser;

import java.util.function.Consumer;

public class StartTypingMessageEvent extends AbstractMessageEvent<StartTypingMessageParser> {

    public StartTypingMessageEvent(Consumer<StartTypingMessageParser> callback) {
        super(callback, StartTypingMessageParser.class);
    }
}
