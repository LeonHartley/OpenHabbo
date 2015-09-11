package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetAchievementShareIdMessageParser;

import java.util.function.Consumer;

public class GetAchievementShareIdMessageEvent extends AbstractMessageEvent<GetAchievementShareIdMessageParser> {

    public GetAchievementShareIdMessageEvent(Consumer<GetAchievementShareIdMessageParser> callback) {
        super(callback, GetAchievementShareIdMessageParser.class);
    }
}
