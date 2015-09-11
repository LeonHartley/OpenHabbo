package com.openhabbo.communication.events.room.action;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.action.BanUserMessageParser;

import java.util.function.Consumer;

public class BanUserMessageEvent extends AbstractMessageEvent<BanUserMessageParser> {

    public BanUserMessageEvent(Consumer<BanUserMessageParser> callback) {
        super(callback, BanUserMessageParser.class);
    }
}
