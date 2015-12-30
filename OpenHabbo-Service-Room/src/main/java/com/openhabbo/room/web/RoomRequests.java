package com.openhabbo.room.web;

import com.google.common.collect.Lists;
import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.communication.composers.navigator.FlatAccessDeniedMessageComposer;
import com.openhabbo.communication.composers.notifications.MOTDNotificationMessageComposer;
import com.openhabbo.communication.composers.room.engine.FloorHeightMapMessageComposer;
import com.openhabbo.communication.composers.room.engine.HeightMapMessageComposer;
import com.openhabbo.communication.composers.room.engine.RoomVisualizationSettingsMessageComposer;
import com.openhabbo.communication.composers.room.session.OpenConnectionMessageComposer;
import com.openhabbo.communication.composers.room.session.RoomReadyMessageComposer;
import com.openhabbo.communication.services.directories.types.SessionDirectory;
import com.openhabbo.room.models.RoomModel;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.UUID;

public class RoomRequests {

    public static String load(Request request, Response response) {
        final String roomId = request.queryParams("roomId");
        final UUID uuid = UUID.fromString(request.queryParams("sessionId"));
        final String password = request.queryParams("password");

        List<MessageComposer> messages = Lists.newArrayList();

        messages.add(new MOTDNotificationMessageComposer("Hey, you're trying to load the room: " + roomId + " with password '" + password + "'"));
        messages.add(new OpenConnectionMessageComposer());
        messages.add(new RoomReadyMessageComposer("model_a", Integer.parseInt(roomId)));

        final String model = "xxxxxxxxxxxx\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxx00000000\r" +
                "xxxxxxxxxxxx\r" +
                "xxxxxxxxxxxx";
        
        final RoomModel roomModel = new RoomModel();
        roomModel.init(model);

        messages.add(new HeightMapMessageComposer(roomModel.getHeightMapString()));
        messages.add(new FloorHeightMapMessageComposer(roomModel.getFloorMapString()));
        messages.add(new RoomVisualizationSettingsMessageComposer());

        SessionDirectory.getInstance().sendMessage(uuid, messages);
        return "{}";
    }
}
