package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.QuestVendingWallItemMessageParser;

import java.util.function.Consumer;

public class QuestVendingWallItemMessageEvent extends AbstractMessageEvent<QuestVendingWallItemMessageParser> {

    public QuestVendingWallItemMessageEvent(Consumer<QuestVendingWallItemMessageParser> callback) {
        super(callback, QuestVendingWallItemMessageParser.class);
    }
}
