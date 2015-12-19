package com.openhabbo.peer.networking.codec.types;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.peer.networking.codec.encoding.WireCodec;
import io.netty.buffer.ByteBuf;

public class MessageComposerData implements OutgoingMessageWrapper {

    private final int header;
    private final ByteBuf buffer;

    public MessageComposerData(int header, ByteBuf buffer) {
        this.header = header;
        this.buffer = buffer;

        this.writeInteger(header);
    }

    @Override
    public int getHeader() {
        return this.header;
    }

    @Override
    public void writeString(String data) {
        this.buffer.writeBytes(data.getBytes());
    }

    @Override
    public void writeInteger(int data) {
        this.writeString(new String(WireCodec.encodeInt(data)));
    }

    @Override
    public void writeByte(byte data) {
        this.buffer.writeByte(data);
    }

    @Override
    public void writeBoolean(boolean data) {
        this.buffer.writeByte((byte) (data ? 'I' : 'H'));
    }

    @Override
    public void writeShort(short data) {
        this.writeInteger(data);
    }
}
