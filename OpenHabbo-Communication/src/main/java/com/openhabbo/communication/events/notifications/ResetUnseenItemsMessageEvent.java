package com.openhabbo.communication.events.notifications;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.notifications.ResetUnseenItemsMessageParser;

import java.util.function.Consumer;

public class ResetUnseenItemsMessageEvent extends AbstractMessageEvent<ResetUnseenItemsMessageParser> {

    public ResetUnseenItemsMessageEvent(Consumer<ResetUnseenItemsMessageParser> callback) {
        super(callback, ResetUnseenItemsMessageParser.class);
    }
}
