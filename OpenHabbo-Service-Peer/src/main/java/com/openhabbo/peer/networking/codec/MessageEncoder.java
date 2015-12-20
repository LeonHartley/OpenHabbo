package com.openhabbo.peer.networking.codec;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.peer.networking.codec.types.MessageComposerData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class MessageEncoder extends MessageToByteEncoder<MessageComposer> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageComposer composer, ByteBuf byteBuf) throws Exception {
        MessageComposerData data = new MessageComposerData(composer.getClass(), byteBuf);

        composer.onCompose(data);
        byteBuf.writeByte(1);

        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
    }
}
