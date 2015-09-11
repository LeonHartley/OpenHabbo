package com.openhabbo.communication.events.recycler;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.recycler.GetRecyclerStatusMessageParser;

import java.util.function.Consumer;

public class GetRecyclerStatusMessageEvent extends AbstractMessageEvent<GetRecyclerStatusMessageParser> {

    public GetRecyclerStatusMessageEvent(Consumer<GetRecyclerStatusMessageParser> callback) {
        super(callback, GetRecyclerStatusMessageParser.class);
    }
}
