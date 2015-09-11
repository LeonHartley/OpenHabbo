package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.GetSongInfoMessageParser;

import java.util.function.Consumer;

public class GetSongInfoMessageEvent extends AbstractMessageEvent<GetSongInfoMessageParser> {

    public GetSongInfoMessageEvent(Consumer<GetSongInfoMessageParser> callback) {
        super(callback, GetSongInfoMessageParser.class);
    }
}
