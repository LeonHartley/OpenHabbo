package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.GetGuestRoomMessageParser;

import java.util.function.Consumer;

public class GetGuestRoomMessageEvent extends AbstractMessageEvent<GetGuestRoomMessageParser> {

    public GetGuestRoomMessageEvent(Consumer<GetGuestRoomMessageParser> callback) {
        super(callback, GetGuestRoomMessageParser.class);
    }
}
