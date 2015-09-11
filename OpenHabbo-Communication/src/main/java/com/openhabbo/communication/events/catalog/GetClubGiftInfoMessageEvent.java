package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetClubGiftInfoMessageParser;

import java.util.function.Consumer;

public class GetClubGiftInfoMessageEvent extends AbstractMessageEvent<GetClubGiftInfoMessageParser> {

    public GetClubGiftInfoMessageEvent(Consumer<GetClubGiftInfoMessageParser> callback) {
        super(callback, GetClubGiftInfoMessageParser.class);
    }
}
