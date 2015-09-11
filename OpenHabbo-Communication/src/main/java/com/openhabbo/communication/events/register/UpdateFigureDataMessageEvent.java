package com.openhabbo.communication.events.register;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.register.UpdateFigureDataMessageParser;

import java.util.function.Consumer;

public class UpdateFigureDataMessageEvent extends AbstractMessageEvent<UpdateFigureDataMessageParser> {

    public UpdateFigureDataMessageEvent(Consumer<UpdateFigureDataMessageParser> callback) {
        super(callback, UpdateFigureDataMessageParser.class);
    }
}
