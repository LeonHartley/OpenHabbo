package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.InitCryptoMessageParser;

import java.util.function.Consumer;

public class InitCryptoMessageEvent extends AbstractMessageEvent<InitCryptoMessageParser> {

    public InitCryptoMessageEvent(Consumer<InitCryptoMessageParser> callback) {
        super(callback, InitCryptoMessageParser.class);
    }
}
