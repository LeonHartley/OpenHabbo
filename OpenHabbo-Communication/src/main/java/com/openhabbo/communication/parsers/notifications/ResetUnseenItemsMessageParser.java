package com.openhabbo.communication.parsers.notifications;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.communication.parsers.AbstractMessageParser;

public class ResetUnseenItemsMessageParser extends AbstractMessageParser {
 
    @Override
    public boolean parse(IncomingMessageWrapper data) {
        return true;
    }

    @Override
    public boolean flush() {
        return true;
    }
}
