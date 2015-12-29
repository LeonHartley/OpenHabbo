package com.openhabbo.communication.services.directories.types.entries;

import java.util.UUID;

public class SessionDirectoryEntry {
    private UUID sessionId;
    private String serviceAlias;
    private int playerId;

    public SessionDirectoryEntry(UUID sessionId, String serviceAlias, int playerId) {
        this.sessionId = sessionId;
        this.serviceAlias = serviceAlias;
        this.playerId = playerId;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
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
