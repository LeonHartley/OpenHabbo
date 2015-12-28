package com.openhabbo.communication.parsers.navigator;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.communication.parsers.AbstractMessageParser;

public class LatestEventsSearchMessageParser extends AbstractMessageParser {

    private int categoryId;

    @Override
    public boolean parse(IncomingMessageWrapper data) {
        this.categoryId = Integer.parseInt(data.readString());
        return true;
    }

    @Override
    public boolean flush() {
        return true;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
