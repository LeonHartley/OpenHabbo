package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.UpdateNavigatorSettingsMessageParser;

import java.util.function.Consumer;

public class UpdateNavigatorSettingsMessageEvent extends AbstractMessageEvent<UpdateNavigatorSettingsMessageParser> {

    public UpdateNavigatorSettingsMessageEvent(Consumer<UpdateNavigatorSettingsMessageParser> callback) {
        super(callback, UpdateNavigatorSettingsMessageParser.class);
    }
}
