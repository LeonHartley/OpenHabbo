package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.GetSoundSettingsMessageParser;

import java.util.function.Consumer;

public class GetSoundSettingsMessageEvent extends AbstractMessageEvent<GetSoundSettingsMessageParser> {

    public GetSoundSettingsMessageEvent(Consumer<GetSoundSettingsMessageParser> callback) {
        super(callback, GetSoundSettingsMessageParser.class);
    }
}
