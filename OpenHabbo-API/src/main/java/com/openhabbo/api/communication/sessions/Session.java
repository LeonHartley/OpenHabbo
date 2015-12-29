package com.openhabbo.api.communication.sessions;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.events.EventHandler;
import com.openhabbo.api.communication.sessions.util.DisconnectReason;
import com.openhabbo.api.data.players.Player;
import com.openhabbo.api.data.rooms.Room;
import com.openhabbo.api.util.Disposable;
import com.openhabbo.api.util.Initializable;

import java.util.List;
import java.util.UUID;

public interface Session extends EventHandler, Initializable, Disposable {
    void send(MessageComposer composer);

    void disconnect(DisconnectReason reason);

    UUID getSessionId();

    boolean isInitialized();

    void onLoginSuccessful();

    Player getPlayerData();

    void setPlayerData(Player playerData);

    List<Room> getRooms();
}
