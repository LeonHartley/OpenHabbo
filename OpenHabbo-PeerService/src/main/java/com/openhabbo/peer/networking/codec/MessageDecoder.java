package com.openhabbo.peer.networking.codec;

import com.openhabbo.peer.networking.codec.types.MessageEventData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {

    private final Logger log = LogManager.getLogger(MessageDecoder.class.getName());

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            if (in.readableBytes() < 6) {
                return;
            }

            in.markReaderIndex();
            int length = in.readInt();

            if (!(in.readableBytes() >= length)) {
                in.resetReaderIndex();
                return;
            }

            if (length < 0) {
                return;
            }

            out.add(new MessageEventData(in.readBytes(length)));
        } catch (Exception e) {
            log.error("Exception during message decoding", e);
        }
    }
}