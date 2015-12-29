package com.openhabbo.communication.services.messages;

import io.netty.channel.Channel;

public class MessageArgs {
    private final Channel channel;
    private final String data;

    public MessageArgs(Channel channel, String data) {
        this.channel = channel;
        this.data = data;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getData() {
        return data;
    }
}
