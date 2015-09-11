package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.FollowFriendMessageParser;

import java.util.function.Consumer;

public class FollowFriendMessageEvent extends AbstractMessageEvent<FollowFriendMessageParser> {

    public FollowFriendMessageEvent(Consumer<FollowFriendMessageParser> callback) {
        super(callback, FollowFriendMessageParser.class);
    }
}
