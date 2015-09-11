package com.openhabbo.communication.events.avatar;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.avatar.SaveWardrobeOutfitMessageParser;

import java.util.function.Consumer;

public class SaveWardrobeOutfitMessageEvent extends AbstractMessageEvent<SaveWardrobeOutfitMessageParser> {

    public SaveWardrobeOutfitMessageEvent(Consumer<SaveWardrobeOutfitMessageParser> callback) {
        super(callback, SaveWardrobeOutfitMessageParser.class);
    }
}
