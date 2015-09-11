package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.GetPopularRoomTagsMessageParser;

import java.util.function.Consumer;

public class GetPopularRoomTagsMessageEvent extends AbstractMessageEvent<GetPopularRoomTagsMessageParser> {

    public GetPopularRoomTagsMessageEvent(Consumer<GetPopularRoomTagsMessageParser> callback) {
        super(callback, GetPopularRoomTagsMessageParser.class);
    }
}
