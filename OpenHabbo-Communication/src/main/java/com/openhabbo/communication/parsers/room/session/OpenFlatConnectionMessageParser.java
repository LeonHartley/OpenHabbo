package com.openhabbo.communication.parsers.room.session;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.communication.parsers.AbstractMessageParser;

public class OpenFlatConnectionMessageParser extends AbstractMessageParser {

    private int roomId;
    private String password;

    @Override
    public boolean parse(IncomingMessageWrapper data) {
        this.roomId = data.readInteger();
        this.password = data.readString();

        return true;
    }

    @Override
    public boolean flush() {
        return true;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getPassword() {
        return password;
    }
}
