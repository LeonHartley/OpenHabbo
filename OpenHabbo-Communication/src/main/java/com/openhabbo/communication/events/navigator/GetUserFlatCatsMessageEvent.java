package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.GetUserFlatCatsMessageParser;

import java.util.function.Consumer;

public class GetUserFlatCatsMessageEvent extends AbstractMessageEvent<GetUserFlatCatsMessageParser> {

    public GetUserFlatCatsMessageEvent(Consumer<GetUserFlatCatsMessageParser> callback) {
        super(callback, GetUserFlatCatsMessageParser.class);
    }
}
