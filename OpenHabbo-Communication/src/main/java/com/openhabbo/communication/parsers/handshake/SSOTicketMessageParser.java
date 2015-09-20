package com.openhabbo.communication.parsers.handshake;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.communication.parsers.AbstractMessageParser;

public class SSOTicketMessageParser extends AbstractMessageParser {

    private String ssoTicket;

    @Override
    public boolean parse(IncomingMessageWrapper data) {
        this.ssoTicket = data.readString();

        return true;
    }

    @Override
    public boolean flush() {
        return true;
    }

    public String getSsoTicket() {
        return ssoTicket;
    }
}
