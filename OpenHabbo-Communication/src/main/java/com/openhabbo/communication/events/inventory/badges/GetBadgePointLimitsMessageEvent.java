package com.openhabbo.communication.events.inventory.badges;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.badges.GetBadgePointLimitsMessageParser;

import java.util.function.Consumer;

public class GetBadgePointLimitsMessageEvent extends AbstractMessageEvent<GetBadgePointLimitsMessageParser> {

    public GetBadgePointLimitsMessageEvent(Consumer<GetBadgePointLimitsMessageParser> callback) {
        super(callback, GetBadgePointLimitsMessageParser.class);
    }
}
