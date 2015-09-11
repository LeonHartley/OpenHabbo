package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.ModAlertMessageParser;

import java.util.function.Consumer;

public class ModAlertMessageEvent extends AbstractMessageEvent<ModAlertMessageParser> {

    public ModAlertMessageEvent(Consumer<ModAlertMessageParser> callback) {
        super(callback, ModAlertMessageParser.class);
    }
}
