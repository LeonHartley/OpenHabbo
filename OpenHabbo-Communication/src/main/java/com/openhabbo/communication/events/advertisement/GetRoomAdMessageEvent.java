package com.openhabbo.communication.events.advertisement;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.advertisement.GetRoomAdMessageParser;

import java.util.function.Consumer;

public class GetRoomAdMessageEvent extends AbstractMessageEvent<GetRoomAdMessageParser> {

    public GetRoomAdMessageEvent(Consumer<GetRoomAdMessageParser> callback) {
        super(callback, GetRoomAdMessageParser.class);
    }
}
