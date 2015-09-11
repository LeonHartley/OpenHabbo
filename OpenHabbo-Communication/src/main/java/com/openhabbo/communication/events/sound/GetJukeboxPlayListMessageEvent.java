package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.GetJukeboxPlayListMessageParser;

import java.util.function.Consumer;

public class GetJukeboxPlayListMessageEvent extends AbstractMessageEvent<GetJukeboxPlayListMessageParser> {

    public GetJukeboxPlayListMessageEvent(Consumer<GetJukeboxPlayListMessageParser> callback) {
        super(callback, GetJukeboxPlayListMessageParser.class);
    }
}
