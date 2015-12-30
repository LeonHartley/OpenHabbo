package com.openhabbo.communication.services.messages.outgoing.sessions;

import com.openhabbo.api.services.OpenHabboService;
import com.openhabbo.communication.services.messages.outgoing.Message;

import java.util.UUID;

public class SessionUnregisterMessage extends Message {

    private UUID uuid;
    private String serviceAlias = OpenHabboService.SERVICE_ALIAS;

    public SessionUnregisterMessage(UUID uuid) {
        super("sessionUnregister");

        this.uuid = uuid;
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
}
