package com.openhabbo.api.communication.data;

public interface IncomingMessageWrapper {
    String readString();

    int readInteger();

    short readShort();

    boolean readBoolean();

    byte readByte();
}
