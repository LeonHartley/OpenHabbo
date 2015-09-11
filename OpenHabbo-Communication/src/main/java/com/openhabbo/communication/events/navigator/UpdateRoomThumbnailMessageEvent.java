package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.UpdateRoomThumbnailMessageParser;

import java.util.function.Consumer;

public class UpdateRoomThumbnailMessageEvent extends AbstractMessageEvent<UpdateRoomThumbnailMessageParser> {

    public UpdateRoomThumbnailMessageEvent(Consumer<UpdateRoomThumbnailMessageParser> callback) {
        super(callback, UpdateRoomThumbnailMessageParser.class);
    }
}
