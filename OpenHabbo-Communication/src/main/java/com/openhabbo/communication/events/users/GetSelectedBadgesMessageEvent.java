package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetSelectedBadgesMessageParser;

import java.util.function.Consumer;

public class GetSelectedBadgesMessageEvent extends AbstractMessageEvent<GetSelectedBadgesMessageParser> {

    public GetSelectedBadgesMessageEvent(Consumer<GetSelectedBadgesMessageParser> callback) {
        super(callback, GetSelectedBadgesMessageParser.class);
    }
}
