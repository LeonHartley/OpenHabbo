package com.openhabbo.api.communication.parsers;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;

public interface MessageParser {
    boolean parse(IncomingMessageWrapper data);

    boolean flush();
}
