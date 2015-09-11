package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.InfoRetrieveMessageParser;

import java.util.function.Consumer;

public class InfoRetrieveMessageEvent extends AbstractMessageEvent<InfoRetrieveMessageParser> {

    public InfoRetrieveMessageEvent(Consumer<InfoRetrieveMessageParser> callback) {
        super(callback, InfoRetrieveMessageParser.class);
    }
}
