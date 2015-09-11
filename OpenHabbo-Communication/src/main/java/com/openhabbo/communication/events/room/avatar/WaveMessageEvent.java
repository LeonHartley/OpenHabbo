package com.openhabbo.communication.events.room.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.avatar.WaveMessageParser;

import java.util.function.Consumer;

public class WaveMessageEvent extends AbstractMessageEvent<WaveMessageParser> {

    public WaveMessageEvent(Consumer<WaveMessageParser> callback) {
        super(callback, WaveMessageParser.class);
    }
}
