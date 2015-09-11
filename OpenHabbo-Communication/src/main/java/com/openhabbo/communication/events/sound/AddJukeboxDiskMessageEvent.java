package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.AddJukeboxDiskMessageParser;

import java.util.function.Consumer;

public class AddJukeboxDiskMessageEvent extends AbstractMessageEvent<AddJukeboxDiskMessageParser> {

    public AddJukeboxDiskMessageEvent(Consumer<AddJukeboxDiskMessageParser> callback) {
        super(callback, AddJukeboxDiskMessageParser.class);
    }
}
