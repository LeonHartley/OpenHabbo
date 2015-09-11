package com.openhabbo.communication.events.userdefinedroomevents;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.userdefinedroomevents.UpdateConditionMessageParser;

import java.util.function.Consumer;

public class UpdateConditionMessageEvent extends AbstractMessageEvent<UpdateConditionMessageParser> {

    public UpdateConditionMessageEvent(Consumer<UpdateConditionMessageParser> callback) {
        super(callback, UpdateConditionMessageParser.class);
    }
}
