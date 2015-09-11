package com.openhabbo.communication.events.sound;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.sound.GetSoundMachinePlayListMessageParser;

import java.util.function.Consumer;

public class GetSoundMachinePlayListMessageEvent extends AbstractMessageEvent<GetSoundMachinePlayListMessageParser> {

    public GetSoundMachinePlayListMessageEvent(Consumer<GetSoundMachinePlayListMessageParser> callback) {
        super(callback, GetSoundMachinePlayListMessageParser.class);
    }
}
