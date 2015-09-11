package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.ModBanMessageParser;

import java.util.function.Consumer;

public class ModBanMessageEvent extends AbstractMessageEvent<ModBanMessageParser> {

    public ModBanMessageEvent(Consumer<ModBanMessageParser> callback) {
        super(callback, ModBanMessageParser.class);
    }
}
