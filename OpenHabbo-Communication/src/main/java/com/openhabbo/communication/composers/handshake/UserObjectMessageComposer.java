package com.openhabbo.communication.composers.handshake;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.api.data.players.Player;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class UserObjectMessageComposer extends AbstractMessageComposer {

    public Player playerData;

    public UserObjectMessageComposer(Player playerData) {
        this.playerData = playerData;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeString(this.playerData.getId() + "");
        data.writeString(this.playerData.getUsername());
        data.writeString(this.playerData.getFigure());
        data.writeString(this.playerData.getGender());
        data.writeString("TODO: MOTTO");
        data.writeString(this.playerData.getUsername());
        data.writeBoolean(false);
        data.writeInteger(0);//respoints
        data.writeInteger(0);//respointstotal
        data.writeInteger(0);//respointspet
        data.writeBoolean(false);
    }
}
