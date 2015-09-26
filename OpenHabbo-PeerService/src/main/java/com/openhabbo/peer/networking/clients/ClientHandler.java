package com.openhabbo.peer.networking.clients;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.master.MasterSessionRegisterMessage;
import com.openhabbo.commons.web.requests.master.MasterSessionUnregisterMessage;
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

        if (wrapper.getHeader() == 206) {
            channelHandlerContext.writeAndFlush("DAQBHHIIKHJIPAIQAdd-MM-yyyy\u0002SAHPB/client\u0002QBH\u0001");
            return;
        } else if(wrapper.getHeader() == 415) {
            channelHandlerContext.writeAndFlush("@BJSA\u0001");
            channelHandlerContext.writeAndFlush("GLH\u0001DbIH\u0001@C\u0001HEI\u0001GGb[`H\u0001GJRGH\u0001LjIwelcome to openhabbo lets get this ball rollin'\u0002\u0001\n");
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

        WebClient.getInstance().dispatchRequest("master", new MasterSessionRegisterMessage(session.getSessionId(),
                OpenHabboPeerService.getInstance().getServiceAlias()));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // dispatch disconnection event to all services that the session is connected to
        Session session = ctx.channel().attr(SessionService.SESSION_ATTRIBUTE).get();

        if(session != null) {
            WebClient.getInstance().dispatchRequest("master", new MasterSessionUnregisterMessage(session.getSessionId()));

            session.dispose();
        }

        ctx.channel().attr(SessionService.SESSION_ATTRIBUTE).remove();
    }

    public static ChannelHandler getInstance() {
        if(instance == null) {
            instance = new ClientHandler();
        }

        return instance;
    }
}
