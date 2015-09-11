package com.openhabbo.communication.events.users;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.users.GetIgnoredUsersMessageParser;

import java.util.function.Consumer;

public class GetIgnoredUsersMessageEvent extends AbstractMessageEvent<GetIgnoredUsersMessageParser> {

    public GetIgnoredUsersMessageEvent(Consumer<GetIgnoredUsersMessageParser> callback) {
        super(callback, GetIgnoredUsersMessageParser.class);
    }
}
