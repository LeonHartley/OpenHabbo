package com.openhabbo.communication.events.inventory.avatareffect;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.inventory.avatareffect.AvatarEffectActivatedMessageParser;

import java.util.function.Consumer;

public class AvatarEffectActivatedMessageEvent extends AbstractMessageEvent<AvatarEffectActivatedMessageParser> {

    public AvatarEffectActivatedMessageEvent(Consumer<AvatarEffectActivatedMessageParser> callback) {
        super(callback, AvatarEffectActivatedMessageParser.class);
    }
}
