package com.openhabbo.communication.events.quest;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.quest.FriendRequestQuestCompleteMessageParser;

import java.util.function.Consumer;

public class FriendRequestQuestCompleteMessageEvent extends AbstractMessageEvent<FriendRequestQuestCompleteMessageParser> {

    public FriendRequestQuestCompleteMessageEvent(Consumer<FriendRequestQuestCompleteMessageParser> callback) {
        super(callback, FriendRequestQuestCompleteMessageParser.class);
    }
}
