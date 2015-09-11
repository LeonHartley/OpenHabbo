package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetHabboClubExtendOfferMessageParser;

import java.util.function.Consumer;

public class GetHabboClubExtendOfferMessageEvent extends AbstractMessageEvent<GetHabboClubExtendOfferMessageParser> {

    public GetHabboClubExtendOfferMessageEvent(Consumer<GetHabboClubExtendOfferMessageParser> callback) {
        super(callback, GetHabboClubExtendOfferMessageParser.class);
    }
}
