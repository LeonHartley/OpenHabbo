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
<<<<<<< HEAD
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, IncomingMessageWrapper wrapper) throws Exception {
        Session session = channelHandlerContext.channel().attr(SessionFactory.SESSION_ATTRIBUTE).get();

        if(session == null) {
            // How do you expect us to handle the message if we aren't even a registered session? :P
            return;
        }

        session.handleEvent(wrapper.getHeader(), wrapper);

        if(wrapper.getHeader() == 206) {
            channelHandlerContext.writeAndFlush("DAQBHHIIKHJIPAIQAdd-MM-yyyy\u0002SAHPB/client\u0002QBH\u0001");
        } else if(wrapper.getHeader() == 415) {
            // sso ticket
            String ssoTicket = wrapper.readString();

            log.info("SSO ticket: {}", ssoTicket);
        } else if(wrapper.getHeader() == 482) {
            log.info(wrapper.readString());
            log.info(wrapper.readString());
            log.info(wrapper.readString());
            log.info(wrapper.readString());
        }
=======
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
>>>>>>> c5c278df3a8fdfc485017c823e5504594d060923
    }

    public static ChannelHandler getInstance() {
        if(instance == null) {
            instance = new ClientHandler();
        }

        return instance;
    }
}
