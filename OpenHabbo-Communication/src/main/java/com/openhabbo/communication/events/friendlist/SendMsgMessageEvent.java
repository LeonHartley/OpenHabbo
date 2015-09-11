package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.SendMsgMessageParser;

import java.util.function.Consumer;

public class SendMsgMessageEvent extends AbstractMessageEvent<SendMsgMessageParser> {

    public SendMsgMessageEvent(Consumer<SendMsgMessageParser> callback) {
        super(callback, SendMsgMessageParser.class);
    }
}
