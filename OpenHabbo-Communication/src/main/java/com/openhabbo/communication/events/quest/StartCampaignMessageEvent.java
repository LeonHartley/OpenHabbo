package com.openhabbo.communication.events.quest;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.quest.StartCampaignMessageParser;

import java.util.function.Consumer;

public class StartCampaignMessageEvent extends AbstractMessageEvent<StartCampaignMessageParser> {

    public StartCampaignMessageEvent(Consumer<StartCampaignMessageParser> callback) {
        super(callback, StartCampaignMessageParser.class);
    }
}
