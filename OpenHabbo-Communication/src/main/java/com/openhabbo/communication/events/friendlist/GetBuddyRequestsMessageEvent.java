package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.GetBuddyRequestsMessageParser;

import java.util.function.Consumer;

public class GetBuddyRequestsMessageEvent extends AbstractMessageEvent<GetBuddyRequestsMessageParser> {

    public GetBuddyRequestsMessageEvent(Consumer<GetBuddyRequestsMessageParser> callback) {
        super(callback, GetBuddyRequestsMessageParser.class);
    }
}
