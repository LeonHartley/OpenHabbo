package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.SetSoundSettingsMessageParser;

import java.util.function.Consumer;

public class SetSoundSettingsMessageEvent extends AbstractMessageEvent<SetSoundSettingsMessageParser> {

    public SetSoundSettingsMessageEvent(Consumer<SetSoundSettingsMessageParser> callback) {
        super(callback, SetSoundSettingsMessageParser.class);
    }
}
