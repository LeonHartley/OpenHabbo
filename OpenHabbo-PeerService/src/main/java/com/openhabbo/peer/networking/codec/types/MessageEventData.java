package com.openhabbo.peer.networking.codec.types;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import io.netty.buffer.ByteBuf;

public class MessageEventData implements IncomingMessageWrapper {

    private final ByteBuf buffer;

    public MessageEventData(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public String readString() {
        return null;
    }

    @Override
    public int readInteger() {
        return 0;
    }

    @Override
    public short readShort() {
        return 0;
    }

    @Override
    public boolean readBoolean() {
        return false;
    }

    @Override
    public byte readByte() {
        return 0;
    }
}
