package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.KickUserMessageParser;

import java.util.function.Consumer;

public class KickUserMessageEvent extends AbstractMessageEvent<KickUserMessageParser> {

    public KickUserMessageEvent(Consumer<KickUserMessageParser> callback) {
        super(callback, KickUserMessageParser.class);
    }
}
