package com.openhabbo.communication.composers.room.engine;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class HeightMapMessageComposer extends AbstractMessageComposer {

    private final String heightmap;

    public HeightMapMessageComposer(final String heightmap) {
        this.heightmap = heightmap;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeString(this.heightmap);
    }
}
