package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.GenerateSecretKeyMessageParser;

import java.util.function.Consumer;

public class GenerateSecretKeyMessageEvent extends AbstractMessageEvent<GenerateSecretKeyMessageParser> {

    public GenerateSecretKeyMessageEvent(Consumer<GenerateSecretKeyMessageParser> callback) {
        super(callback, GenerateSecretKeyMessageParser.class);
    }
}
