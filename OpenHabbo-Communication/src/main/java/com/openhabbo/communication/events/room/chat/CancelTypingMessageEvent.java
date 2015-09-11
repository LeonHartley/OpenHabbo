package com.openhabbo.communication.events.room.chat;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.chat.CancelTypingMessageParser;

import java.util.function.Consumer;

public class CancelTypingMessageEvent extends AbstractMessageEvent<CancelTypingMessageParser> {

    public CancelTypingMessageEvent(Consumer<CancelTypingMessageParser> callback) {
        super(callback, CancelTypingMessageParser.class);
    }
}
