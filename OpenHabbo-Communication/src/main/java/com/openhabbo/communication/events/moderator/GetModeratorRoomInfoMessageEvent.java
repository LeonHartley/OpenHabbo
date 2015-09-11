package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.GetModeratorRoomInfoMessageParser;

import java.util.function.Consumer;

public class GetModeratorRoomInfoMessageEvent extends AbstractMessageEvent<GetModeratorRoomInfoMessageParser> {

    public GetModeratorRoomInfoMessageEvent(Consumer<GetModeratorRoomInfoMessageParser> callback) {
        super(callback, GetModeratorRoomInfoMessageParser.class);
    }
}
