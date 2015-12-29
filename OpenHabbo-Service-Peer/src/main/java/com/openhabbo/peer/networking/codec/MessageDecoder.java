package com.openhabbo.peer.networking.codec;

import com.openhabbo.peer.networking.codec.encoding.Base64Codec;
import com.openhabbo.peer.networking.codec.types.MessageEventData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {

    private final Logger log = LogManager.getLogger(MessageDecoder.class.getName());

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            if (in.readableBytes() < 5) {
                return;
            }

            in.markReaderIndex();

            int length = Base64Codec.decodeInt(in.readBytes(3).array());

            if (length < 0) {
                return;
            }

            if (!(in.readableBytes() >= length)) {
                in.resetReaderIndex();
                return;
            }

            int header = Base64Codec.decodeInt(in.readBytes(2).array());

            log.info("Decoded event data {}, length {}, header {}", in.toString(CharsetUtil.UTF_8), length - 2, header);
            out.add(new MessageEventData((short) header, in.readBytes(length - 2)));
        } catch (Exception e) {
            log.error("Exception during message decoding", e);
        }
    }
}