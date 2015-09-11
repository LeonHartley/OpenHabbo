package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.RemoveBuddyMessageParser;

import java.util.function.Consumer;

public class RemoveBuddyMessageEvent extends AbstractMessageEvent<RemoveBuddyMessageParser> {

    public RemoveBuddyMessageEvent(Consumer<RemoveBuddyMessageParser> callback) {
        super(callback, RemoveBuddyMessageParser.class);
    }
}
