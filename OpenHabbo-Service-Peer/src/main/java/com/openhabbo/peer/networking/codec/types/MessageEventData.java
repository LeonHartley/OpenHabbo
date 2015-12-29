package com.openhabbo.peer.networking.codec.types;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.peer.networking.codec.encoding.Base64Codec;
import com.openhabbo.peer.networking.codec.encoding.WireCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;

public class MessageEventData implements IncomingMessageWrapper {
    private final short header;
    private final ByteBuf buffer;

    public MessageEventData(short header, ByteBuf buffer) {
        this.header = header;
        this.buffer = buffer;
    }

    @Override
    public short getHeader() {
        return this.header;
    }

    @Override
    public String readString() {
        final int length = Base64Codec.decodeInt(this.readBytes(2));
        final byte[] data = this.readBytes(length);

        return new String(data, CharsetUtil.UTF_8);
    }

    @Override
    public int readInteger() {
        int[] data = WireCodec.decodeInt(
                this.buffer.readBytes(WireCodec.MAX_INTEGER_BYTE_AMOUNT).array()
        );

        this.buffer.readerIndex((this.buffer.readerIndex() - 6) + data[1]);
        return data[0];
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
        byte b = this.buffer.readByte();
        return b;
    }

    private byte[] readBytes(int num) {
        byte[] bytes = new byte[num];

        for (int x = 0; x < num; x++) {
            bytes[x] = this.buffer.readByte();
        }

        return bytes;
    }
}
