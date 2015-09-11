package com.openhabbo.communication.events.inventory.furni;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.furni.RequestRoomPropertySetMessageParser;

import java.util.function.Consumer;

public class RequestRoomPropertySetMessageEvent extends AbstractMessageEvent<RequestRoomPropertySetMessageParser> {

    public RequestRoomPropertySetMessageEvent(Consumer<RequestRoomPropertySetMessageParser> callback) {
        super(callback, RequestRoomPropertySetMessageParser.class);
    }
}
