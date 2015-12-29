package com.openhabbo.communication.services.clients;

import com.openhabbo.communication.services.ServiceCommunicationManager;
import com.openhabbo.communication.services.messages.ServiceCommunicationMessageHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ServiceCommunicationHandler extends SimpleChannelInboundHandler<String> {

    private final Logger log = LogManager.getLogger(ServiceCommunicationManager.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String o) throws Exception {
        ServiceCommunicationMessageHandler.getInstance().handleMessage(o, channelHandlerContext.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        if(cause instanceof IOException) {
            ctx.close().addListener(channelFuture -> ServiceCommunicationManager.getInstance().reconnect());

            return;
        }

        log.warn("Exception caught", cause);
    }
}
