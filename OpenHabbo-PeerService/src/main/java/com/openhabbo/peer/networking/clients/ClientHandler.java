package com.openhabbo.peer.networking.clients;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.core.sessions.SessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ChannelHandler.Sharable
public class ClientHandler extends SimpleChannelInboundHandler<IncomingMessageWrapper> {
    private static final Logger log = LogManager.getLogger(ClientHandler.class.getName());
    private static ChannelHandler instance;

    @Override
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
    }

    public static ChannelHandler getInstance() {
        if(instance == null) {
            instance = new ClientHandler();
        }

        return instance;
    }
}
