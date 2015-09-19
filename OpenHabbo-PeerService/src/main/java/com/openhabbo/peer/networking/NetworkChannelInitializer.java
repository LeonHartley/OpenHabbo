package com.openhabbo.peer.networking;

import com.openhabbo.config.OpenHabboPeerServiceConfiguration;
import com.openhabbo.peer.networking.clients.ClientHandler;
import com.openhabbo.peer.networking.codec.MessageDecoder;
import com.openhabbo.peer.networking.codec.MessageEncoder;
import com.openhabbo.peer.networking.codec.XMLPolicyDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

public class NetworkChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final EventExecutorGroup executors;
    private final OpenHabboPeerServiceConfiguration configuration;

    public NetworkChannelInitializer(EventExecutorGroup eventExecutors, OpenHabboPeerServiceConfiguration configuration) {
        this.executors = eventExecutors;
        this.configuration = configuration;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.config().setTrafficClass(0x18);

        channel.pipeline().addLast("xmlDecoder", new XMLPolicyDecoder())
                .addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8))
                .addLast("messageDecoder", new MessageDecoder())
                .addLast("messageEncoder", new MessageEncoder());

        // TODO: Idle timer stuff.

        channel.pipeline().addLast(this.executors, "channelHandler", ClientHandler.getInstance());
    }
}
