package com.openhabbo.communication.events.facebook;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.facebook.FaceBookIsLoggedOnMessageParser;

import java.util.function.Consumer;

public class FaceBookIsLoggedOnMessageEvent extends AbstractMessageEvent<FaceBookIsLoggedOnMessageParser> {

    public FaceBookIsLoggedOnMessageEvent(Consumer<FaceBookIsLoggedOnMessageParser> callback) {
        super(callback, FaceBookIsLoggedOnMessageParser.class);
    }
}
