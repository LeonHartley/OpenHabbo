package com.openhabbo.communication.services.directories.types;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.sessions.Session;
import com.openhabbo.api.services.OpenHabboService;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.peer.PeerSendMessage;
import com.openhabbo.communication.services.directories.Directory;
import com.openhabbo.communication.services.directories.types.entries.SessionDirectoryEntry;
import com.openhabbo.communication.sessons.SessionService;

import java.util.List;
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
        if (!this.isRegistered(id)) {
            return;
        }

        this.playerIdToSessionId.remove(this.get(id).getPlayerId());

        super.remove(id);
    }

    public void sendMessage(UUID sessionId, MessageComposer composer) {
        if (!this.isRegistered(sessionId)) {
            return;
        }

        SessionDirectoryEntry entry = this.get(sessionId);

        if (entry.getServiceAlias().equals(OpenHabboService.SERVICE_ALIAS)) {
            Session session = SessionService.getInstance().getSessionById(sessionId);

            if (session != null) {
                session.send(composer);
            }
        } else {
            WebClient.getInstance().dispatchRequest(entry.getServiceAlias(), new PeerSendMessage(entry.getSessionId(), composer));
        }
    }

    public void sendMessage(UUID sessionId, List<MessageComposer> composers) {
        if (!this.isRegistered(sessionId)) {
            return;
        }

        SessionDirectoryEntry entry = this.get(sessionId);

        if (entry.getServiceAlias().equals(OpenHabboService.SERVICE_ALIAS)) {
            Session session = SessionService.getInstance().getSessionById(sessionId);

            if (session != null) {
                for (MessageComposer composer : composers) {
                    session.send(composer);
                }
            }
        } else {
            WebClient.getInstance().dispatchRequest(entry.getServiceAlias(), new PeerSendMessage(entry.getSessionId(), composers));
        }
    }


    public UUID getSessionIdByPlayerId(int playerId) {
        return this.playerIdToSessionId.get(playerId);
    }

    public static SessionDirectory getInstance() {
        if (instance == null) {
            instance = new SessionDirectory();
        }

        return instance;
    }
}
