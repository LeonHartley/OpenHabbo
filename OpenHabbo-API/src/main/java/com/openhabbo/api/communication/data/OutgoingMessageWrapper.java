package com.openhabbo.api.communication.data;

public interface OutgoingMessageWrapper {
    void writeString(String data);

    void writeInteger(int data);

    void writeByte(byte data);

    void writeBoolean(boolean data);

    void writeShort(short data);
}
