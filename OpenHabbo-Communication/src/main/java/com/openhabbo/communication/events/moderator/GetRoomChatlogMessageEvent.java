package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.GetRoomChatlogMessageParser;

import java.util.function.Consumer;

public class GetRoomChatlogMessageEvent extends AbstractMessageEvent<GetRoomChatlogMessageParser> {

    public GetRoomChatlogMessageEvent(Consumer<GetRoomChatlogMessageParser> callback) {
        super(callback, GetRoomChatlogMessageParser.class);
    }
}
