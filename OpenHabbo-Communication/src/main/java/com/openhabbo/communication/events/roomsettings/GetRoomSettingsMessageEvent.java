package com.openhabbo.communication.events.roomsettings;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.roomsettings.GetRoomSettingsMessageParser;

import java.util.function.Consumer;

public class GetRoomSettingsMessageEvent extends AbstractMessageEvent<GetRoomSettingsMessageParser> {

    public GetRoomSettingsMessageEvent(Consumer<GetRoomSettingsMessageParser> callback) {
        super(callback, GetRoomSettingsMessageParser.class);
    }
}
