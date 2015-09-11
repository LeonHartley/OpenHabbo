package com.openhabbo.communication.events.room.chat;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.chat.ChatMessageParser;

import java.util.function.Consumer;

public class ChatMessageEvent extends AbstractMessageEvent<ChatMessageParser> {

    public ChatMessageEvent(Consumer<ChatMessageParser> callback) {
        super(callback, ChatMessageParser.class);
    }
}
