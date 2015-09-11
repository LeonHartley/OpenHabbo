package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.GetPublicSpaceCastLibsMessageParser;

import java.util.function.Consumer;

public class GetPublicSpaceCastLibsMessageEvent extends AbstractMessageEvent<GetPublicSpaceCastLibsMessageParser> {

    public GetPublicSpaceCastLibsMessageEvent(Consumer<GetPublicSpaceCastLibsMessageParser> callback) {
        super(callback, GetPublicSpaceCastLibsMessageParser.class);
    }
}
