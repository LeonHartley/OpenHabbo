package com.openhabbo.communication.composers.room.engine;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class RoomVisualizationSettingsMessageComposer extends AbstractMessageComposer {

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeBoolean(false);
        data.writeInteger(0);
        data.writeInteger(0);
    }
}
