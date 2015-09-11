package com.openhabbo.communication.events.facebook;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.facebook.FaceBookIsLoggedOffMessageParser;

import java.util.function.Consumer;

public class FaceBookIsLoggedOffMessageEvent extends AbstractMessageEvent<FaceBookIsLoggedOffMessageParser> {

    public FaceBookIsLoggedOffMessageEvent(Consumer<FaceBookIsLoggedOffMessageParser> callback) {
        super(callback, FaceBookIsLoggedOffMessageParser.class);
    }
}
