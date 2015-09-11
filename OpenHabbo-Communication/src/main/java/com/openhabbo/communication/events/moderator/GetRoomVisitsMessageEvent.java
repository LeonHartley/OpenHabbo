package com.openhabbo.communication.events.moderator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.moderator.GetRoomVisitsMessageParser;

import java.util.function.Consumer;

public class GetRoomVisitsMessageEvent extends AbstractMessageEvent<GetRoomVisitsMessageParser> {

    public GetRoomVisitsMessageEvent(Consumer<GetRoomVisitsMessageParser> callback) {
        super(callback, GetRoomVisitsMessageParser.class);
    }
}
