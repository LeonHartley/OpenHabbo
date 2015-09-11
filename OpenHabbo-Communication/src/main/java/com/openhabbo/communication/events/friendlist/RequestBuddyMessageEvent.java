package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.RequestBuddyMessageParser;

import java.util.function.Consumer;

public class RequestBuddyMessageEvent extends AbstractMessageEvent<RequestBuddyMessageParser> {

    public RequestBuddyMessageEvent(Consumer<RequestBuddyMessageParser> callback) {
        super(callback, RequestBuddyMessageParser.class);
    }
}
