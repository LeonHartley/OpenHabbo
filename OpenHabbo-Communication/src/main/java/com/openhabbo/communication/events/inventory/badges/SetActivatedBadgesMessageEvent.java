package com.openhabbo.communication.events.inventory.badges;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.badges.SetActivatedBadgesMessageParser;

import java.util.function.Consumer;

public class SetActivatedBadgesMessageEvent extends AbstractMessageEvent<SetActivatedBadgesMessageParser> {

    public SetActivatedBadgesMessageEvent(Consumer<SetActivatedBadgesMessageParser> callback) {
        super(callback, SetActivatedBadgesMessageParser.class);
    }
}
