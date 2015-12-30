package com.openhabbo.communication.services.messages.outgoing.sessions;

import com.openhabbo.api.services.OpenHabboService;
import com.openhabbo.communication.services.messages.outgoing.Message;

import java.util.UUID;

public class SessionRegisterMessage extends Message {

    private UUID uuid;
    private String serviceAlias = OpenHabboService.SERVICE_ALIAS;
    private int playerId;

    public SessionRegisterMessage(UUID uuid, int playerId) {
        super("sessionRegister");

        this.uuid = uuid;
        this.playerId = playerId;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getServiceAlias() {
        return serviceAlias;
    }

    public void setServiceAlias(String serviceAlias) {
        this.serviceAlias = serviceAlias;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
