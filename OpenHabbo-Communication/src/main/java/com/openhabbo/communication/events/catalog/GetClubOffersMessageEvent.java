package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetClubOffersMessageParser;

import java.util.function.Consumer;

public class GetClubOffersMessageEvent extends AbstractMessageEvent<GetClubOffersMessageParser> {

    public GetClubOffersMessageEvent(Consumer<GetClubOffersMessageParser> callback) {
        super(callback, GetClubOffersMessageParser.class);
    }
}
