package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.FriendListUpdateMessageParser;

import java.util.function.Consumer;

public class FriendListUpdateMessageEvent extends AbstractMessageEvent<FriendListUpdateMessageParser> {

    public FriendListUpdateMessageEvent(Consumer<FriendListUpdateMessageParser> callback) {
        super(callback, FriendListUpdateMessageParser.class);
    }
}
