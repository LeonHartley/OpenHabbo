package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.MyFriendsRoomsSearchMessageParser;

import java.util.function.Consumer;

public class MyFriendsRoomsSearchMessageEvent extends AbstractMessageEvent<MyFriendsRoomsSearchMessageParser> {

    public MyFriendsRoomsSearchMessageEvent(Consumer<MyFriendsRoomsSearchMessageParser> callback) {
        super(callback, MyFriendsRoomsSearchMessageParser.class);
    }
}
