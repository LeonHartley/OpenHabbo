package com.openhabbo.communication.composers.room.engine;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class FloorHeightMapMessageComposer extends AbstractMessageComposer {
    private final String modelData;

    public FloorHeightMapMessageComposer(final String modelData) {
        this.modelData = modelData;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeString(modelData);
    }
}
