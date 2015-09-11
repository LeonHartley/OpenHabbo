package com.openhabbo.communication.events.inventory.achievements;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.achievements.GetAchievementsMessageParser;

import java.util.function.Consumer;

public class GetAchievementsMessageEvent extends AbstractMessageEvent<GetAchievementsMessageParser> {

    public GetAchievementsMessageEvent(Consumer<GetAchievementsMessageParser> callback) {
        super(callback, GetAchievementsMessageParser.class);
    }
}
