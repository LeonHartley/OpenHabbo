package com.openhabbo.communication.services.directories.types;

import com.openhabbo.communication.services.directories.Directory;
import com.openhabbo.communication.services.directories.types.entries.SessionDirectoryEntry;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SessionDirectory extends Directory<UUID, SessionDirectoryEntry> {
    private static SessionDirectory instance;

    private final Map<Integer, UUID> playerIdToSessionId = new ConcurrentHashMap<>();

    @Override
    public void put(UUID id, SessionDirectoryEntry entry) {
        super.put(id, entry);

        this.playerIdToSessionId.put(entry.getPlayerId(), id);
    }

    @Override
    public void remove(UUID id) {
        this.playerIdToSessionId.remove(this.get(id).getPlayerId());

        super.remove(id);
    }

    public UUID getSessionIdByPlayerId(int playerId) {
        return this.playerIdToSessionId.get(playerId);
    }

    public static SessionDirectory getInstance() {
        if(instance == null) {
            instance = new SessionDirectory();
        }

        return instance;
    }
}
