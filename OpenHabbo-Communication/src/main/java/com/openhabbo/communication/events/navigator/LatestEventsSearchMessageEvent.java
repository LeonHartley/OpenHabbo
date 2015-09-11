package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.LatestEventsSearchMessageParser;

import java.util.function.Consumer;

public class LatestEventsSearchMessageEvent extends AbstractMessageEvent<LatestEventsSearchMessageParser> {

    public LatestEventsSearchMessageEvent(Consumer<LatestEventsSearchMessageParser> callback) {
        super(callback, LatestEventsSearchMessageParser.class);
    }
}
