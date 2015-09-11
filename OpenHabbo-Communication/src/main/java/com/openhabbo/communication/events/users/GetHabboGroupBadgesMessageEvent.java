package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetHabboGroupBadgesMessageParser;

import java.util.function.Consumer;

public class GetHabboGroupBadgesMessageEvent extends AbstractMessageEvent<GetHabboGroupBadgesMessageParser> {

    public GetHabboGroupBadgesMessageEvent(Consumer<GetHabboGroupBadgesMessageParser> callback) {
        super(callback, GetHabboGroupBadgesMessageParser.class);
    }
}
