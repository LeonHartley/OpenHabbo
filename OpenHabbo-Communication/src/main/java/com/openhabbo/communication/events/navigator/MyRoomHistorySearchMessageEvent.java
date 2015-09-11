package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.MyRoomHistorySearchMessageParser;

import java.util.function.Consumer;

public class MyRoomHistorySearchMessageEvent extends AbstractMessageEvent<MyRoomHistorySearchMessageParser> {

    public MyRoomHistorySearchMessageEvent(Consumer<MyRoomHistorySearchMessageParser> callback) {
        super(callback, MyRoomHistorySearchMessageParser.class);
    }
}
