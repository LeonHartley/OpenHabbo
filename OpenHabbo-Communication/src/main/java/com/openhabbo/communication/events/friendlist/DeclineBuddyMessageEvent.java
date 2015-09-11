package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.DeclineBuddyMessageParser;

import java.util.function.Consumer;

public class DeclineBuddyMessageEvent extends AbstractMessageEvent<DeclineBuddyMessageParser> {

    public DeclineBuddyMessageEvent(Consumer<DeclineBuddyMessageParser> callback) {
        super(callback, DeclineBuddyMessageParser.class);
    }
}
