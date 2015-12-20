package com.openhabbo.peer.networking.clients;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.master.MasterSessionRegisterMessage;
import com.openhabbo.commons.web.requests.master.MasterSessionUnregisterMessage;
import com.openhabbo.communication.composers.handshake.AuthenticationOKMessageComposer;
import com.openhabbo.communication.composers.notifications.MOTDNotificationMessageComposer;
import com.openhabbo.core.sessions.SessionService;
import com.openhabbo.peer.OpenHabboPeerService;
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
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, IncomingMessageWrapper wrapper) throws Exception {
        Session session = channelHandlerContext.channel().attr(SessionService.SESSION_ATTRIBUTE).get();

        if (session == null) {
            // How do you expect us to handle the message if we aren't even a registered session? :P
            return;
        }

        if (!session.isInitialized()) {
            session.initialize();
        }

        //topkek amirite?
        if (wrapper.getHeader() == 206) {
            channelHandlerContext.writeAndFlush("DAQBHHIIKHJIPAIQAdd-MM-yyyy\u0002SAHPB/client\u0002QBH\u0001");
            return;
        }

        session.handleEvent(wrapper.getHeader(), wrapper);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws java.lang.Exception {
        this.activeConnections.incrementAndGet();

        // TODO: Connection limit?

        Session session = SessionService.getInstance().createSession(ctx.channel());

        if(session == null) {
            // disconnect if the session was not created successfully.
            ctx.close();
            return;
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // dispatch disconnection event to all services that the session is connected to
        Session session = ctx.channel().attr(SessionService.SESSION_ATTRIBUTE).get();

        if(session != null) {
            session.dispose();
        }

        ctx.channel().attr(SessionService.SESSION_ATTRIBUTE).remove();
        this.activeConnections.decrementAndGet();
    }

    public static ChannelHandler getInstance() {
        if(instance == null) {
            instance = new ClientHandler();
        }

        return instance;
    }
}
