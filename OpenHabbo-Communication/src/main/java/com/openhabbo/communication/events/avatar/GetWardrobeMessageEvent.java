package com.openhabbo.communication.events.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.avatar.GetWardrobeMessageParser;

import java.util.function.Consumer;

public class GetWardrobeMessageEvent extends AbstractMessageEvent<GetWardrobeMessageParser> {

    public GetWardrobeMessageEvent(Consumer<GetWardrobeMessageParser> callback) {
        super(callback, GetWardrobeMessageParser.class);
    }
}
