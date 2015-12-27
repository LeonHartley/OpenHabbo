package com.openhabbo.core.sessions.messaging;

import com.openhabbo.api.communication.sessions.SessionComponent;
import com.openhabbo.api.communication.sessions.util.DisconnectReason;
import com.openhabbo.communication.composers.handshake.UserObjectMessageComposer;
import com.openhabbo.communication.composers.inventory.purse.CreditBalanceMessageComposer;
import com.openhabbo.communication.composers.notifications.HabboActivityPointNotificationMessageComposer;
import com.openhabbo.communication.events.inventory.purse.GetCreditsInfoMessageEvent;
import com.openhabbo.communication.events.users.ScrGetUserInfoMessageEvent;
import com.openhabbo.communication.parsers.inventory.purse.GetCreditsInfoMessageParser;
import com.openhabbo.communication.parsers.users.ScrGetUserInfoMessageParser;
import com.openhabbo.core.sessions.PlayerSession;

public class PlayerMessageHandler implements SessionComponent {

    private final PlayerSession playerSession;

    public PlayerMessageHandler(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    @Override
    public void initialize() {
        this.playerSession.registerEvent(new ScrGetUserInfoMessageEvent(this::onGetUserInfo));
        this.playerSession.registerEvent(new GetCreditsInfoMessageEvent(this::onGetCreditsInfo));
    }

    @Override
    public void dispose() {
        this.playerSession.unregisterEvent(ScrGetUserInfoMessageEvent.class);
        this.playerSession.unregisterEvent(GetCreditsInfoMessageEvent.class);
    }

    public void onGetUserInfo(ScrGetUserInfoMessageParser parser) {
        if (this.playerSession.getPlayerData() == null) {
            this.playerSession.disconnect(DisconnectReason.ERROR);
            return;
        }

        this.playerSession.send(new UserObjectMessageComposer(this.playerSession.getPlayerData()));
        this.playerSession.unregisterEvent(ScrGetUserInfoMessageEvent.class);
    }

    public void onGetCreditsInfo(GetCreditsInfoMessageParser parser) {
        if (this.playerSession.getPlayerData() == null) {
            this.playerSession.disconnect(DisconnectReason.ERROR);
        }

        this.playerSession.send(new CreditBalanceMessageComposer(this.playerSession.getPlayerData().getBalanceCoins()));
        this.playerSession.send(new HabboActivityPointNotificationMessageComposer(this.playerSession.getPlayerData().getBalanceActivityPoints()));

        this.playerSession.unregisterEvent(GetCreditsInfoMessageEvent.class);
    }
}
