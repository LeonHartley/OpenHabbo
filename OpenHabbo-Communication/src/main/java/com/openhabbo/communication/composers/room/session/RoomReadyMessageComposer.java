package com.openhabbo.communication.composers.room.session;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class RoomReadyMessageComposer extends AbstractMessageComposer {

    private String modelName;
    private int roomId;

    public RoomReadyMessageComposer(String modelName, int roomId) {
        this.modelName = modelName;
        this.roomId = roomId;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeString(this.modelName);
        data.writeInteger(this.roomId);
    }
}
