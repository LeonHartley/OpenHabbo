package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetMOTDMessageParser;

import java.util.function.Consumer;

public class GetMOTDMessageEvent extends AbstractMessageEvent<GetMOTDMessageParser> {

    public GetMOTDMessageEvent(Consumer<GetMOTDMessageParser> callback) {
        super(callback, GetMOTDMessageParser.class);
    }
}
