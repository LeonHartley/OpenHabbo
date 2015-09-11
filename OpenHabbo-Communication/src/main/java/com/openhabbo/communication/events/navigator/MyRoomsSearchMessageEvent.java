package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.MyRoomsSearchMessageParser;

import java.util.function.Consumer;

public class MyRoomsSearchMessageEvent extends AbstractMessageEvent<MyRoomsSearchMessageParser> {

    public MyRoomsSearchMessageEvent(Consumer<MyRoomsSearchMessageParser> callback) {
        super(callback, MyRoomsSearchMessageParser.class);
    }
}
