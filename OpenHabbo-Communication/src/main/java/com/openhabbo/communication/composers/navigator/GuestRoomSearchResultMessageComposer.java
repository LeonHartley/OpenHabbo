package com.openhabbo.communication.composers.navigator;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.api.data.rooms.Room;
import com.openhabbo.api.data.rooms.util.RoomAccessType;
import com.openhabbo.communication.composers.AbstractMessageComposer;

import java.util.List;

public class GuestRoomSearchResultMessageComposer extends AbstractMessageComposer {

    private final int categoryId;
    private final int mode;
    private final String query;
    private final List<Room> rooms;

    public GuestRoomSearchResultMessageComposer(int categoryId, int mode, String query, List<Room> rooms) {
        this.categoryId = categoryId;
        this.mode = mode;
        this.query = query;
        this.rooms = rooms;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeInteger(this.categoryId);
        data.writeInteger(this.mode);
        data.writeString(this.query);
        data.writeInteger(this.rooms.size());

        for(Room room : this.rooms) {
            data.writeInteger(room.getId());
            data.writeBoolean(false); // showing event
            data.writeString(room.getName());
            data.writeString(room.getPlayerName());
            data.writeInteger(RoomAccessType.intValue(room.getAccessType()));
            data.writeInteger(0);//current users
            data.writeInteger(100);//todo: max users
            data.writeString(room.getDescription());
            data.writeInteger(0);
            data.writeBoolean(true); //todo: can trade
            data.writeInteger(room.getRating());
            data.writeInteger(0);//todo: category id
            data.writeString("");//event started time
            data.writeInteger(0);//todo: tags

            data.writeInteger(0);// icon background ID
            data.writeInteger(0);// overlay image ID
            data.writeInteger(0);// objects count (array: key, value)

            data.writeInteger(0);
            data.writeInteger(1);
        }
    }
}
