package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.MoveAvatarMessageParser;

import java.util.function.Consumer;

public class MoveAvatarMessageEvent extends AbstractMessageEvent<MoveAvatarMessageParser> {

    public MoveAvatarMessageEvent(Consumer<MoveAvatarMessageParser> callback) {
        super(callback, MoveAvatarMessageParser.class);
    }
}
