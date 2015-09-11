package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.AddFavouriteRoomMessageParser;

import java.util.function.Consumer;

public class AddFavouriteRoomMessageEvent extends AbstractMessageEvent<AddFavouriteRoomMessageParser> {

    public AddFavouriteRoomMessageEvent(Consumer<AddFavouriteRoomMessageParser> callback) {
        super(callback, AddFavouriteRoomMessageParser.class);
    }
}
