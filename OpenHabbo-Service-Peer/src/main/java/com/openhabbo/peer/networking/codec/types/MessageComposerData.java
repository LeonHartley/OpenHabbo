package com.openhabbo.peer.networking.codec.types;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.api.communication.headers.MessageHeaderProviderService;
import com.openhabbo.peer.networking.codec.encoding.Base64Codec;
import com.openhabbo.peer.networking.codec.encoding.WireCodec;
import io.netty.buffer.ByteBuf;

public class MessageComposerData implements OutgoingMessageWrapper {

    private final ByteBuf buffer;

    public MessageComposerData(Class<? extends MessageComposer> clazz, ByteBuf buffer) {
        this.buffer = buffer;

        this.buffer.writeBytes(Base64Codec.encodeInt(MessageHeaderProviderService.getProvider().getHeaderByComposerClass(clazz), 2));
    }

    @Override
    public void writeString(String data) {
        this.buffer.writeBytes(data.getBytes());
        this.buffer.writeByte(2);
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
        this.writeByte((byte) (data ? 73 : 72));
    }

    @Override
    public void writeShort(short data) {
        this.writeInteger(data);
    }
}