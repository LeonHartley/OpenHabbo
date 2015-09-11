package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.VersionCheckMessageParser;

import java.util.function.Consumer;

public class VersionCheckMessageEvent extends AbstractMessageEvent<VersionCheckMessageParser> {

    public VersionCheckMessageEvent(Consumer<VersionCheckMessageParser> callback) {
        super(callback, VersionCheckMessageParser.class);
    }
}
