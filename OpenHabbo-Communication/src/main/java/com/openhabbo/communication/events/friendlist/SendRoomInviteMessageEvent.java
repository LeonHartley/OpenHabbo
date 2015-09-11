package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.SendRoomInviteMessageParser;

import java.util.function.Consumer;

public class SendRoomInviteMessageEvent extends AbstractMessageEvent<SendRoomInviteMessageParser> {

    public SendRoomInviteMessageEvent(Consumer<SendRoomInviteMessageParser> callback) {
        super(callback, SendRoomInviteMessageParser.class);
    }
}
