package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.OpenPetPackageMessageParser;

import java.util.function.Consumer;

public class OpenPetPackageMessageEvent extends AbstractMessageEvent<OpenPetPackageMessageParser> {

    public OpenPetPackageMessageEvent(Consumer<OpenPetPackageMessageParser> callback) {
        super(callback, OpenPetPackageMessageParser.class);
    }
}
