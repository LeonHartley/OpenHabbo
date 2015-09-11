package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.FindNewFriendsMessageParser;

import java.util.function.Consumer;

public class FindNewFriendsMessageEvent extends AbstractMessageEvent<FindNewFriendsMessageParser> {

    public FindNewFriendsMessageEvent(Consumer<FindNewFriendsMessageParser> callback) {
        super(callback, FindNewFriendsMessageParser.class);
    }
}
