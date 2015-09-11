package com.openhabbo.communication.events.handshake;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.handshake.SSOTicketMessageParser;

import java.util.function.Consumer;

public class SSOTicketMessageEvent extends AbstractMessageEvent<SSOTicketMessageParser> {

    public SSOTicketMessageEvent(Consumer<SSOTicketMessageParser> callback) {
        super(callback, SSOTicketMessageParser.class);
    }
}
