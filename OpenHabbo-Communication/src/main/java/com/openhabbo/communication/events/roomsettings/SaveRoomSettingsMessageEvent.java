package com.openhabbo.communication.events.roomsettings;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.roomsettings.SaveRoomSettingsMessageParser;

import java.util.function.Consumer;

public class SaveRoomSettingsMessageEvent extends AbstractMessageEvent<SaveRoomSettingsMessageParser> {

    public SaveRoomSettingsMessageEvent(Consumer<SaveRoomSettingsMessageParser> callback) {
        super(callback, SaveRoomSettingsMessageParser.class);
    }
}
