package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.GetSessionParametersMessageParser;

import java.util.function.Consumer;

public class GetSessionParametersMessageEvent extends AbstractMessageEvent<GetSessionParametersMessageParser> {

    public GetSessionParametersMessageEvent(Consumer<GetSessionParametersMessageParser> callback) {
        super(callback, GetSessionParametersMessageParser.class);
    }
}
