package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.AcceptBuddyMessageParser;

import java.util.function.Consumer;

public class AcceptBuddyMessageEvent extends AbstractMessageEvent<AcceptBuddyMessageParser> {

    public AcceptBuddyMessageEvent(Consumer<AcceptBuddyMessageParser> callback) {
        super(callback, AcceptBuddyMessageParser.class);
    }
}
