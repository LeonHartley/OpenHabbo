package com.openhabbo.communication.events.userdefinedroomevents;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.userdefinedroomevents.UpdateTriggerMessageParser;

import java.util.function.Consumer;

public class UpdateTriggerMessageEvent extends AbstractMessageEvent<UpdateTriggerMessageParser> {

    public UpdateTriggerMessageEvent(Consumer<UpdateTriggerMessageParser> callback) {
        super(callback, UpdateTriggerMessageParser.class);
    }
}
