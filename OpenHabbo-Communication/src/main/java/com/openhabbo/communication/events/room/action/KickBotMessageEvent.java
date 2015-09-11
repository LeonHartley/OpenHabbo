package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.KickBotMessageParser;

import java.util.function.Consumer;

public class KickBotMessageEvent extends AbstractMessageEvent<KickBotMessageParser> {

    public KickBotMessageEvent(Consumer<KickBotMessageParser> callback) {
        super(callback, KickBotMessageParser.class);
    }
}
