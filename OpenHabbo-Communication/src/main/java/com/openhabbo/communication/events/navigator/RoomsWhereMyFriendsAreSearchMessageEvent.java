package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.RoomsWhereMyFriendsAreSearchMessageParser;

import java.util.function.Consumer;

public class RoomsWhereMyFriendsAreSearchMessageEvent extends AbstractMessageEvent<RoomsWhereMyFriendsAreSearchMessageParser> {

    public RoomsWhereMyFriendsAreSearchMessageEvent(Consumer<RoomsWhereMyFriendsAreSearchMessageParser> callback) {
        super(callback, RoomsWhereMyFriendsAreSearchMessageParser.class);
    }
}
