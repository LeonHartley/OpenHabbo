package com.openhabbo.communication.events.recycler;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.recycler.GetRecyclerPrizesMessageParser;

import java.util.function.Consumer;

public class GetRecyclerPrizesMessageEvent extends AbstractMessageEvent<GetRecyclerPrizesMessageParser> {

    public GetRecyclerPrizesMessageEvent(Consumer<GetRecyclerPrizesMessageParser> callback) {
        super(callback, GetRecyclerPrizesMessageParser.class);
    }
}
