package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.OpenWelcomeGiftMessageParser;

import java.util.function.Consumer;

public class OpenWelcomeGiftMessageEvent extends AbstractMessageEvent<OpenWelcomeGiftMessageParser> {

    public OpenWelcomeGiftMessageEvent(Consumer<OpenWelcomeGiftMessageParser> callback) {
        super(callback, OpenWelcomeGiftMessageParser.class);
    }
}
