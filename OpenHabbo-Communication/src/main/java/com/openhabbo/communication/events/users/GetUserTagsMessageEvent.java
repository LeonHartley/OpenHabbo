package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetUserTagsMessageParser;

import java.util.function.Consumer;

public class GetUserTagsMessageEvent extends AbstractMessageEvent<GetUserTagsMessageParser> {

    public GetUserTagsMessageEvent(Consumer<GetUserTagsMessageParser> callback) {
        super(callback, GetUserTagsMessageParser.class);
    }
}
