package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetUserNotificationsMessageParser;

import java.util.function.Consumer;

public class GetUserNotificationsMessageEvent extends AbstractMessageEvent<GetUserNotificationsMessageParser> {

    public GetUserNotificationsMessageEvent(Consumer<GetUserNotificationsMessageParser> callback) {
        super(callback, GetUserNotificationsMessageParser.class);
    }
}
