package com.openhabbo.communication.events.catalog;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.catalog.GetHabboBasicMembershipExtendOfferMessageParser;

import java.util.function.Consumer;

public class GetHabboBasicMembershipExtendOfferMessageEvent extends AbstractMessageEvent<GetHabboBasicMembershipExtendOfferMessageParser> {

    public GetHabboBasicMembershipExtendOfferMessageEvent(Consumer<GetHabboBasicMembershipExtendOfferMessageParser> callback) {
        super(callback, GetHabboBasicMembershipExtendOfferMessageParser.class);
    }
}
