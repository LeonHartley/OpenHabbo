package com.openhabbo.communication.events.room.chat;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.chat.WhisperMessageParser;

import java.util.function.Consumer;

public class WhisperMessageEvent extends AbstractMessageEvent<WhisperMessageParser> {

    public WhisperMessageEvent(Consumer<WhisperMessageParser> callback) {
        super(callback, WhisperMessageParser.class);
    }
}
