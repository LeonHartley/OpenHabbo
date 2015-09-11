package com.openhabbo.communication.parsers.help;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.communication.parsers.AbstractMessageParser;

public class SearchFaqsMessageParser extends AbstractMessageParser {
 
    @Override
    public boolean parse(IncomingMessageWrapper data) {
        return true;
    }

    @Override
    public boolean flush() {
        return true;
    }
}
