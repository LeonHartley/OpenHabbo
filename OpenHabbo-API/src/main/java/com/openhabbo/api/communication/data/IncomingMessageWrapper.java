package com.openhabbo.api.communication.data;

public interface IncomingMessageWrapper {
    short getHeader();

    String readString();

    int readInteger();

    short readShort();

    boolean readBoolean();

    byte readByte();
}
