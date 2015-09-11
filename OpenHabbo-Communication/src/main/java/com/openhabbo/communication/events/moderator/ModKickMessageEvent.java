package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.ModKickMessageParser;

import java.util.function.Consumer;

public class ModKickMessageEvent extends AbstractMessageEvent<ModKickMessageParser> {

    public ModKickMessageEvent(Consumer<ModKickMessageParser> callback) {
        super(callback, ModKickMessageParser.class);
    }
}
