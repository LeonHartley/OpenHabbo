package com.openhabbo.communication.events.navigator;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.navigator.RoomsWithHighestScoreSearchMessageParser;

import java.util.function.Consumer;

public class RoomsWithHighestScoreSearchMessageEvent extends AbstractMessageEvent<RoomsWithHighestScoreSearchMessageParser> {

    public RoomsWithHighestScoreSearchMessageEvent(Consumer<RoomsWithHighestScoreSearchMessageParser> callback) {
        super(callback, RoomsWithHighestScoreSearchMessageParser.class);
    }
}
