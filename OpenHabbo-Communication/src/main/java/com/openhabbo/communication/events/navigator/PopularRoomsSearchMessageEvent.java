package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.PopularRoomsSearchMessageParser;

import java.util.function.Consumer;

public class PopularRoomsSearchMessageEvent extends AbstractMessageEvent<PopularRoomsSearchMessageParser> {

    public PopularRoomsSearchMessageEvent(Consumer<PopularRoomsSearchMessageParser> callback) {
        super(callback, PopularRoomsSearchMessageParser.class);
    }
}
