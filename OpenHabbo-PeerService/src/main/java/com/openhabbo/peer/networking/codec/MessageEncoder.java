package com.openhabbo.peer.networking.codec;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.peer.networking.codec.types.MessageComposerData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<MessageComposer> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageComposer composer, ByteBuf byteBuf) throws Exception {
        MessageComposerData data = new MessageComposerData(byteBuf);

        composer.onCompose(data);
//
//        if (!composer.hasLength()) {
//            composer.content().setInt(0, composer.content().writerIndex() - 4);
//        }
    }
}
