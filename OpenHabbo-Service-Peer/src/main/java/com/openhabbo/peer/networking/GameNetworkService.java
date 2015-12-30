package com.openhabbo.peer.networking;

import com.openhabbo.api.communication.headers.MessageHeaderProviderService;
import com.openhabbo.communication.headers.DefaultMessageHeaderProvider;
import com.openhabbo.communication.sessons.SessionService;
import com.openhabbo.config.OpenHabboPeerServiceConfiguration;
import com.openhabbo.core.sessions.CoreSessionService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultMessageSizeEstimator;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetSocketAddress;

public class GameNetworkService {
    private final Logger log = LogManager.getLogger(GameNetworkService.class.getName());
    private final OpenHabboPeerServiceConfiguration configuration;

    public GameNetworkService(OpenHabboPeerServiceConfiguration configuration) {
        this.configuration = configuration;

        // configure the services
        MessageHeaderProviderService.set(new DefaultMessageHeaderProvider());
        SessionService.set(new CoreSessionService());
    }

    public void initialize() {

        EventLoopGroup acceptGroup;
        EventLoopGroup ioGroup;
        EventLoopGroup channelGroup;

        final boolean isEpollEnabled = this.configuration.useEpoll();
        final boolean isEpollAvailable = Epoll.isAvailable();

        if (isEpollAvailable && isEpollEnabled) {
            log.info("Epoll is enabled");
            acceptGroup = new EpollEventLoopGroup(this.configuration.getAcceptGroupThreads());
            ioGroup = new EpollEventLoopGroup(this.configuration.getIoGroupThreads());
            channelGroup = new EpollEventLoopGroup(this.configuration.getChannelGroupThreads());
        } else {
            if (isEpollAvailable) {
                log.info("Epoll is available but not enabled");
            } else {
                log.info("Epoll is not available");
            }

            acceptGroup = new NioEventLoopGroup(this.configuration.getAcceptGroupThreads());
            ioGroup = new NioEventLoopGroup(this.configuration.getIoGroupThreads());
            channelGroup = new NioEventLoopGroup(this.configuration.getChannelGroupThreads());
        }

        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(acceptGroup, ioGroup)
                .channel(isEpollAvailable && isEpollEnabled ? EpollServerSocketChannel.class : NioServerSocketChannel.class)
                .childHandler(new NetworkChannelInitializer(channelGroup, this.configuration))
                .option(ChannelOption.SO_BACKLOG, this.configuration.getBacklog())
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, 32 * 1024)
                .option(ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, 64 * 1024)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.MESSAGE_SIZE_ESTIMATOR, DefaultMessageSizeEstimator.DEFAULT)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childOption(ChannelOption.WRITE_BUFFER_LOW_WATER_MARK, 32 * 1024)
                .childOption(ChannelOption.WRITE_BUFFER_HIGH_WATER_MARK, 64 * 1024);

        for (int port : this.configuration.getGamePorts()) {
            this.bind(bootstrap, this.configuration.getGameAddress(), port);
        }

        log.info("OpenHabbo Peer Service listening on ports: {}", this.configuration.getGamePorts());
    }

    private void bind(ServerBootstrap bootstrap, String ip, int port) {
        try {
            bootstrap.bind(new InetSocketAddress(ip, port)).addListener(objectFuture -> {
                if (!objectFuture.isSuccess()) {
                    log.fatal("Failed to initialize network service on address: " + ip + ":" + port);
                    System.exit(0);
                }
            });
        } catch (Exception e) {
            log.fatal("Failed to initialize network service on address: " + ip + ":" + port);
            System.exit(0);
        }
    }
}
