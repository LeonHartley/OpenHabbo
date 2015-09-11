package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.GetUserChatlogMessageParser;

import java.util.function.Consumer;

public class GetUserChatlogMessageEvent extends AbstractMessageEvent<GetUserChatlogMessageParser> {

    public GetUserChatlogMessageEvent(Consumer<GetUserChatlogMessageParser> callback) {
        super(callback, GetUserChatlogMessageParser.class);
    }
}
