package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.ModeratorActionMessageParser;

import java.util.function.Consumer;

public class ModeratorActionMessageEvent extends AbstractMessageEvent<ModeratorActionMessageParser> {

    public ModeratorActionMessageEvent(Consumer<ModeratorActionMessageParser> callback) {
        super(callback, ModeratorActionMessageParser.class);
    }
}
