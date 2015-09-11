package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.ModerateRoomMessageParser;

import java.util.function.Consumer;

public class ModerateRoomMessageEvent extends AbstractMessageEvent<ModerateRoomMessageParser> {

    public ModerateRoomMessageEvent(Consumer<ModerateRoomMessageParser> callback) {
        super(callback, ModerateRoomMessageParser.class);
    }
}
