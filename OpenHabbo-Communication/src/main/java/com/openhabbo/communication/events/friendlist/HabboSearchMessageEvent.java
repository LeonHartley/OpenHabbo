package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.HabboSearchMessageParser;

import java.util.function.Consumer;

public class HabboSearchMessageEvent extends AbstractMessageEvent<HabboSearchMessageParser> {

    public HabboSearchMessageEvent(Consumer<HabboSearchMessageParser> callback) {
        super(callback, HabboSearchMessageParser.class);
    }
}
