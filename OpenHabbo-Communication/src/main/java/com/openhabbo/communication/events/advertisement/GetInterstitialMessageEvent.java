package com.openhabbo.communication.events.advertisement;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.advertisement.GetInterstitialMessageParser;

import java.util.function.Consumer;

public class GetInterstitialMessageEvent extends AbstractMessageEvent<GetInterstitialMessageParser> {

    public GetInterstitialMessageEvent(Consumer<GetInterstitialMessageParser> callback) {
        super(callback, GetInterstitialMessageParser.class);
    }
}
