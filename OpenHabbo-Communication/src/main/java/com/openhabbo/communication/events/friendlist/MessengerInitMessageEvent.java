package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.MessengerInitMessageParser;

import java.util.function.Consumer;

public class MessengerInitMessageEvent extends AbstractMessageEvent<MessengerInitMessageParser> {

    public MessengerInitMessageEvent(Consumer<MessengerInitMessageParser> callback) {
        super(callback, MessengerInitMessageParser.class);
    }
}
