package com.openhabbo.core.sessions.messaging;

import com.openhabbo.api.communication.sessions.SessionComponent;
import com.openhabbo.commons.collections.CollectionsUtil;
import com.openhabbo.communication.composers.navigator.GuestRoomSearchResultMessageComposer;
import com.openhabbo.communication.events.navigator.LatestEventsSearchMessageEvent;
import com.openhabbo.communication.events.navigator.MyRoomsSearchMessageEvent;
import com.openhabbo.communication.events.navigator.PopularRoomsSearchMessageEvent;
import com.openhabbo.communication.parsers.navigator.LatestEventsSearchMessageParser;
import com.openhabbo.communication.parsers.navigator.MyRoomsSearchMessageParser;
import com.openhabbo.communication.parsers.navigator.PopularRoomsSearchMessageParser;
import com.openhabbo.core.sessions.PlayerSession;

public class NavigatorMessageHandler implements SessionComponent {

    private final PlayerSession playerSession;

    public NavigatorMessageHandler(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    @Override
    public void initialize() {
        this.playerSession.registerEvent(new MyRoomsSearchMessageEvent(this::onMyRoomsSearch));
        this.playerSession.registerEvent(new LatestEventsSearchMessageEvent(this::onEventsSearch));
        this.playerSession.registerEvent(new PopularRoomsSearchMessageEvent(this::onPopularRoomsSearch));
    }

    @Override
    public void dispose() {
        this.playerSession.unregisterEvent(MyRoomsSearchMessageEvent.class);
    }

    public void onMyRoomsSearch(MyRoomsSearchMessageParser parser) {
        if(this.playerSession.getRooms() != null) {
            this.playerSession.send(new GuestRoomSearchResultMessageComposer(0, 5, "", this.playerSession.getRooms()));
        }
    }

    public void onEventsSearch(LatestEventsSearchMessageParser parser) {
        this.playerSession.send(new GuestRoomSearchResultMessageComposer(parser.getCategoryId(), 12, "", CollectionsUtil.createList()));
    }

    public void onPopularRoomsSearch(PopularRoomsSearchMessageParser parser) {
        this.playerSession.send(new GuestRoomSearchResultMessageComposer(0, 1, "", CollectionsUtil.createList()));
    }
}
