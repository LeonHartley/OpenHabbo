package com.openhabbo.communication.events.inventory.avatareffect;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.avatareffect.AvatarEffectSelectedMessageParser;

import java.util.function.Consumer;

public class AvatarEffectSelectedMessageEvent extends AbstractMessageEvent<AvatarEffectSelectedMessageParser> {

    public AvatarEffectSelectedMessageEvent(Consumer<AvatarEffectSelectedMessageParser> callback) {
        super(callback, AvatarEffectSelectedMessageParser.class);
    }
}
