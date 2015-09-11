package com.openhabbo.communication.events.inventory.badges;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.badges.GetBadgesMessageParser;

import java.util.function.Consumer;

public class GetBadgesMessageEvent extends AbstractMessageEvent<GetBadgesMessageParser> {

    public GetBadgesMessageEvent(Consumer<GetBadgesMessageParser> callback) {
        super(callback, GetBadgesMessageParser.class);
    }
}
