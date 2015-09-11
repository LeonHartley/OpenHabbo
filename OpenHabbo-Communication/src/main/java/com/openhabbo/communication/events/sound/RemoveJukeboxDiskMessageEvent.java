package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.RemoveJukeboxDiskMessageParser;

import java.util.function.Consumer;

public class RemoveJukeboxDiskMessageEvent extends AbstractMessageEvent<RemoveJukeboxDiskMessageParser> {

    public RemoveJukeboxDiskMessageEvent(Consumer<RemoveJukeboxDiskMessageParser> callback) {
        super(callback, RemoveJukeboxDiskMessageParser.class);
    }
}
