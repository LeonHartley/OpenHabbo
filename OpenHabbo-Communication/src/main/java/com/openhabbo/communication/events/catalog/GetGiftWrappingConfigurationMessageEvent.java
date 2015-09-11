package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetGiftWrappingConfigurationMessageParser;

import java.util.function.Consumer;

public class GetGiftWrappingConfigurationMessageEvent extends AbstractMessageEvent<GetGiftWrappingConfigurationMessageParser> {

    public GetGiftWrappingConfigurationMessageEvent(Consumer<GetGiftWrappingConfigurationMessageParser> callback) {
        super(callback, GetGiftWrappingConfigurationMessageParser.class);
    }
}
