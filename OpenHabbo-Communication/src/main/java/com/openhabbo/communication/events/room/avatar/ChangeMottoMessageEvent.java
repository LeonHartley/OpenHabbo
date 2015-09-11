package com.openhabbo.communication.events.room.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.avatar.ChangeMottoMessageParser;

import java.util.function.Consumer;

public class ChangeMottoMessageEvent extends AbstractMessageEvent<ChangeMottoMessageParser> {

    public ChangeMottoMessageEvent(Consumer<ChangeMottoMessageParser> callback) {
        super(callback, ChangeMottoMessageParser.class);
    }
}
