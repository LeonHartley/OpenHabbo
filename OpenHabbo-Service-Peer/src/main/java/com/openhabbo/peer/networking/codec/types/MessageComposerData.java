package com.openhabbo.peer.networking.codec.types;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import io.netty.buffer.ByteBuf;

public class MessageComposerData implements OutgoingMessageWrapper {

    private final int header;
    private final ByteBuf buffer;

    public MessageComposerData(int header, ByteBuf buffer) {
        this.header = header;
        this.buffer = buffer;
    }

    @Override
    public int getHeader() {
        return this.header;
    }

    @Override
    public void writeString(String data) {

    }

    @Override
    public void writeInteger(int data) {

    }

    @Override
    public void writeByte(byte data) {

    }

    @Override
    public void writeBoolean(boolean data) {

    }

    @Override
    public void writeShort(short data) {

    }
}
