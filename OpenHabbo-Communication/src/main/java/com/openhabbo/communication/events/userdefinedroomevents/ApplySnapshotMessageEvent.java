package com.openhabbo.communication.events.userdefinedroomevents;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.userdefinedroomevents.ApplySnapshotMessageParser;

import java.util.function.Consumer;

public class ApplySnapshotMessageEvent extends AbstractMessageEvent<ApplySnapshotMessageParser> {

    public ApplySnapshotMessageEvent(Consumer<ApplySnapshotMessageParser> callback) {
        super(callback, ApplySnapshotMessageParser.class);
    }
}
