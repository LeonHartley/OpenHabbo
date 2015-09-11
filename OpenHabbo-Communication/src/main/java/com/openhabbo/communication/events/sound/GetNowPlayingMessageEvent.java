package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.GetNowPlayingMessageParser;

import java.util.function.Consumer;

public class GetNowPlayingMessageEvent extends AbstractMessageEvent<GetNowPlayingMessageParser> {

    public GetNowPlayingMessageEvent(Consumer<GetNowPlayingMessageParser> callback) {
        super(callback, GetNowPlayingMessageParser.class);
    }
}
