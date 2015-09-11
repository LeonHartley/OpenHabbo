package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.GetModeratorUserInfoMessageParser;

import java.util.function.Consumer;

public class GetModeratorUserInfoMessageEvent extends AbstractMessageEvent<GetModeratorUserInfoMessageParser> {

    public GetModeratorUserInfoMessageEvent(Consumer<GetModeratorUserInfoMessageParser> callback) {
        super(callback, GetModeratorUserInfoMessageParser.class);
    }
}
