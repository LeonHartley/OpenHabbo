package com.openhabbo.peer.networking.clients;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.core.sessions.SessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

@ChannelHandler.Sharable
public class ClientHandler extends SimpleChannelInboundHandler<IncomingMessageWrapper> {
    private static final Logger log = LogManager.getLogger(ClientHandler.class.getName());
    private static ChannelHandler instance;

    private final AtomicInteger activeConnections = new AtomicInteger(0);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws java.lang.Exception {
        this.activeConnections.incrementAndGet();

        Session session = SessionFactory.getInstance().createSession(ctx.channel());

        if(session == null) {
            // disconnect if the session was not created successfully.
            ctx.close();
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, IncomingMessageWrapper wrapper) throws Exception {
    }

    public static ChannelHandler getInstance() {
        if(instance == null) {
            instance = new ClientHandler();
        }

        return instance;
    }
}
