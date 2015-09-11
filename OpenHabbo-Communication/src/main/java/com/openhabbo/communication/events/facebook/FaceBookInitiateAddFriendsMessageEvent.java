package com.openhabbo.communication.events.facebook;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.facebook.FaceBookInitiateAddFriendsMessageParser;

import java.util.function.Consumer;

public class FaceBookInitiateAddFriendsMessageEvent extends AbstractMessageEvent<FaceBookInitiateAddFriendsMessageParser> {

    public FaceBookInitiateAddFriendsMessageEvent(Consumer<FaceBookInitiateAddFriendsMessageParser> callback) {
        super(callback, FaceBookInitiateAddFriendsMessageParser.class);
    }
}
