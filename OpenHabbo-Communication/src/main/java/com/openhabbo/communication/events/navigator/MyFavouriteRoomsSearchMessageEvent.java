package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.MyFavouriteRoomsSearchMessageParser;

import java.util.function.Consumer;

public class MyFavouriteRoomsSearchMessageEvent extends AbstractMessageEvent<MyFavouriteRoomsSearchMessageParser> {

    public MyFavouriteRoomsSearchMessageEvent(Consumer<MyFavouriteRoomsSearchMessageParser> callback) {
        super(callback, MyFavouriteRoomsSearchMessageParser.class);
    }
}
