package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.AddSpamWallPostItMessageParser;

import java.util.function.Consumer;

public class AddSpamWallPostItMessageEvent extends AbstractMessageEvent<AddSpamWallPostItMessageParser> {

    public AddSpamWallPostItMessageEvent(Consumer<AddSpamWallPostItMessageParser> callback) {
        super(callback, AddSpamWallPostItMessageParser.class);
    }
}
