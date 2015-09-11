package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.ToggleStaffPickMessageParser;

import java.util.function.Consumer;

public class ToggleStaffPickMessageEvent extends AbstractMessageEvent<ToggleStaffPickMessageParser> {

    public ToggleStaffPickMessageEvent(Consumer<ToggleStaffPickMessageParser> callback) {
        super(callback, ToggleStaffPickMessageParser.class);
    }
}
