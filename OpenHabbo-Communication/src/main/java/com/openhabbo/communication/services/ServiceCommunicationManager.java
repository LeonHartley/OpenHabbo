package com.openhabbo.communication.services;

import com.openhabbo.api.util.Initializable;
import com.openhabbo.communication.services.clients.ServiceCommunicationHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class ServiceCommunicationManager implements Initializable {

    private static ServiceCommunicationManager instance;
    private static final Logger log = LogManager.getLogger(ServiceCommunicationManager.class);

    private String host;
    private int port;

    private Channel channel;

    private final EventLoopGroup loopGroup = new NioEventLoopGroup(2);

    public ServiceCommunicationManager() {

    }

    @Override
    public void initialize() {
        this.initialize("127.0.0.1", 3001);
    }

    public void initialize(String host, int port) {
        this.host = host;
        this.port = port;

        this.configureBootstrap(new Bootstrap());
    }

    private Bootstrap configureBootstrap(Bootstrap bootstrap) {
        bootstrap.group(this.loopGroup);
        bootstrap.channel(NioSocketChannel.class);

        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.TCP_NODELAY, true);

        final ServiceCommunicationHandler handler = new ServiceCommunicationHandler();
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new StringEncoder());
                socketChannel.pipeline().addLast(new StringDecoder());
                socketChannel.pipeline().addLast(handler);
            }
        });

        bootstrap.remoteAddress(this.host, this.port);

        ChannelFuture future = bootstrap.connect();

        future.addListener(new ConnectionListener());
        this.channel = future.channel();
        return bootstrap;
    }

    public class ConnectionListener implements ChannelFutureListener {

        @Override
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if(!channelFuture.isSuccess()) {
                // Failed to connect.. We need to reconnect!
                log.warn("Failed to connect to master service, attempting to reestablish connection in 100ms");
                final EventLoopGroup loopGroup = ServiceCommunicationManager.getInstance().getLoopGroup();

                loopGroup.schedule(ServiceCommunicationManager.this::reconnect, 100, TimeUnit.MILLISECONDS);
            } else {
                log.debug("Connection established to the Master service");
            }
        }

    }
    public void reconnect() {
        ServiceCommunicationManager.getInstance().configureBootstrap(new Bootstrap());
    }

    public Channel getChannel() {
        return channel;
    }

    public EventLoopGroup getLoopGroup() {
        return this.loopGroup;
    }

    public static ServiceCommunicationManager getInstance() {
        if(instance == null) {
            instance = new ServiceCommunicationManager();
        }

        return instance;
    }
}
