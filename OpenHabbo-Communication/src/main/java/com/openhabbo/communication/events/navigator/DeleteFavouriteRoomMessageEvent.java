package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.DeleteFavouriteRoomMessageParser;

import java.util.function.Consumer;

public class DeleteFavouriteRoomMessageEvent extends AbstractMessageEvent<DeleteFavouriteRoomMessageParser> {

    public DeleteFavouriteRoomMessageEvent(Consumer<DeleteFavouriteRoomMessageParser> callback) {
        super(callback, DeleteFavouriteRoomMessageParser.class);
    }
}
