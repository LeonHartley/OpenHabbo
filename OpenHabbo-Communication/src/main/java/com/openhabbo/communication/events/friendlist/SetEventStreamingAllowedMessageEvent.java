package com.openhabbo.communication.events.friendlist;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.friendlist.SetEventStreamingAllowedMessageParser;

import java.util.function.Consumer;

public class SetEventStreamingAllowedMessageEvent extends AbstractMessageEvent<SetEventStreamingAllowedMessageParser> {

    public SetEventStreamingAllowedMessageEvent(Consumer<SetEventStreamingAllowedMessageParser> callback) {
        super(callback, SetEventStreamingAllowedMessageParser.class);
    }
}
