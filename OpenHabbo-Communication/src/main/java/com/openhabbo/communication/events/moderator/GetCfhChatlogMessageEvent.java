package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.GetCfhChatlogMessageParser;

import java.util.function.Consumer;

public class GetCfhChatlogMessageEvent extends AbstractMessageEvent<GetCfhChatlogMessageParser> {

    public GetCfhChatlogMessageEvent(Consumer<GetCfhChatlogMessageParser> callback) {
        super(callback, GetCfhChatlogMessageParser.class);
    }
}
