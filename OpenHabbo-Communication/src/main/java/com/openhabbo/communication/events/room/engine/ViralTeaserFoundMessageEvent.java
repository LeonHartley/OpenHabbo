package com.openhabbo.communication.events.room.engine;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.engine.ViralTeaserFoundMessageParser;

import java.util.function.Consumer;

public class ViralTeaserFoundMessageEvent extends AbstractMessageEvent<ViralTeaserFoundMessageParser> {

    public ViralTeaserFoundMessageEvent(Consumer<ViralTeaserFoundMessageParser> callback) {
        super(callback, ViralTeaserFoundMessageParser.class);
    }
}
