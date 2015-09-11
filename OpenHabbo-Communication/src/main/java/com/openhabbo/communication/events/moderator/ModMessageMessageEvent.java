package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.ModMessageMessageParser;

import java.util.function.Consumer;

public class ModMessageMessageEvent extends AbstractMessageEvent<ModMessageMessageParser> {

    public ModMessageMessageEvent(Consumer<ModMessageMessageParser> callback) {
        super(callback, ModMessageMessageParser.class);
    }
}
