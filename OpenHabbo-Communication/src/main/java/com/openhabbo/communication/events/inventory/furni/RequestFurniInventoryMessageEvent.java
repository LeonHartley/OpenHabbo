package com.openhabbo.communication.events.inventory.furni;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.furni.RequestFurniInventoryMessageParser;

import java.util.function.Consumer;

public class RequestFurniInventoryMessageEvent extends AbstractMessageEvent<RequestFurniInventoryMessageParser> {

    public RequestFurniInventoryMessageEvent(Consumer<RequestFurniInventoryMessageParser> callback) {
        super(callback, RequestFurniInventoryMessageParser.class);
    }
}
