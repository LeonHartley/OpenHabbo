package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.GetOfficialRoomsMessageParser;

import java.util.function.Consumer;

public class GetOfficialRoomsMessageEvent extends AbstractMessageEvent<GetOfficialRoomsMessageParser> {

    public GetOfficialRoomsMessageEvent(Consumer<GetOfficialRoomsMessageParser> callback) {
        super(callback, GetOfficialRoomsMessageParser.class);
    }
}
