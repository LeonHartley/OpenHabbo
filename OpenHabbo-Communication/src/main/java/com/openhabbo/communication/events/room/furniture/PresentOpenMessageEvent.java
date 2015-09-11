package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.PresentOpenMessageParser;

import java.util.function.Consumer;

public class PresentOpenMessageEvent extends AbstractMessageEvent<PresentOpenMessageParser> {

    public PresentOpenMessageEvent(Consumer<PresentOpenMessageParser> callback) {
        super(callback, PresentOpenMessageParser.class);
    }
}
