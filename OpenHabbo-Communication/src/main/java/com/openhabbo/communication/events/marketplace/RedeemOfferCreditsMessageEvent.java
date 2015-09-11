package com.openhabbo.communication.events.marketplace;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.marketplace.RedeemOfferCreditsMessageParser;

import java.util.function.Consumer;

public class RedeemOfferCreditsMessageEvent extends AbstractMessageEvent<RedeemOfferCreditsMessageParser> {

    public RedeemOfferCreditsMessageEvent(Consumer<RedeemOfferCreditsMessageParser> callback) {
        super(callback, RedeemOfferCreditsMessageParser.class);
    }
}
