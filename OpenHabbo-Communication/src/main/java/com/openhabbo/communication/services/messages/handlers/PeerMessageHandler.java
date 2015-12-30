package com.openhabbo.communication.services.messages.handlers;

import com.mashape.unirest.http.JsonNode;
import com.openhabbo.communication.services.directories.types.SessionDirectory;
import com.openhabbo.communication.services.directories.types.entries.SessionDirectoryEntry;
import com.openhabbo.communication.services.messages.MessageArgs;

import java.util.UUID;

public class PeerMessageHandler {
    public static void sessionRegistered(MessageArgs args) {
        JsonNode data = new JsonNode(args.getData());

        final UUID uuid = UUID.fromString(data.getObject().getString("uuid"));
        final String serviceAlias = data.getObject().getString("serviceAlias");
        final int playerId = data.getObject().getInt("playerId");

        SessionDirectory.getInstance().put(uuid, new SessionDirectoryEntry(uuid, serviceAlias, playerId));
    }

    public static void sessionUnregistered(MessageArgs args) {
        JsonNode data = new JsonNode(args.getData());

        final UUID uuid = UUID.fromString(data.getObject().getString("uuid"));
        SessionDirectory.getInstance().remove(uuid);
    }
}
