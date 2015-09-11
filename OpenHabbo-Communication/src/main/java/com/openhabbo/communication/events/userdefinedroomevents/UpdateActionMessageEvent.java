package com.openhabbo.communication.events.userdefinedroomevents;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.userdefinedroomevents.UpdateActionMessageParser;

import java.util.function.Consumer;

public class UpdateActionMessageEvent extends AbstractMessageEvent<UpdateActionMessageParser> {

    public UpdateActionMessageEvent(Consumer<UpdateActionMessageParser> callback) {
        super(callback, UpdateActionMessageParser.class);
    }
}
