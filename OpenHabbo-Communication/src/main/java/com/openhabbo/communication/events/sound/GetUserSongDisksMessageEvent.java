package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.GetUserSongDisksMessageParser;

import java.util.function.Consumer;

public class GetUserSongDisksMessageEvent extends AbstractMessageEvent<GetUserSongDisksMessageParser> {

    public GetUserSongDisksMessageEvent(Consumer<GetUserSongDisksMessageParser> callback) {
        super(callback, GetUserSongDisksMessageParser.class);
    }
}
