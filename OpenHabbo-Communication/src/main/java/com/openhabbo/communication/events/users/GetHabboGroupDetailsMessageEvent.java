package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetHabboGroupDetailsMessageParser;

import java.util.function.Consumer;

public class GetHabboGroupDetailsMessageEvent extends AbstractMessageEvent<GetHabboGroupDetailsMessageParser> {

    public GetHabboGroupDetailsMessageEvent(Consumer<GetHabboGroupDetailsMessageParser> callback) {
        super(callback, GetHabboGroupDetailsMessageParser.class);
    }
}
