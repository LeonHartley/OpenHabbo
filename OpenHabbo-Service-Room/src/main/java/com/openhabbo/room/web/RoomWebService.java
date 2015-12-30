package com.openhabbo.room.web;

import com.openhabbo.commons.logging.JettyLogger;
import com.openhabbo.commons.web.DefaultWebServiceFilters;
import com.openhabbo.commons.web.transformers.JsonTransformer;
import com.openhabbo.room.OpenHabboRoomService;
import org.eclipse.jetty.util.log.Log;
import spark.Spark;

import static spark.Spark.get;
import static spark.Spark.post;

public class RoomWebService {
    private static RoomWebService roomWebService;

    private final JsonTransformer jsonTransformer = new JsonTransformer();

    public RoomWebService() {
    }

    public void initialize() {
        Log.setLog(new JettyLogger());

        // configure the web service.
        Spark.port(2000);
        DefaultWebServiceFilters.apply(OpenHabboRoomService.getInstance().getServiceConfiguration());

        this.applyRoutes();
    }

    private void applyRoutes() {
        get("/", (req, res) -> "{\"response\":\"hi\"}");

        post("/room/load", RoomRequests::load, jsonTransformer);
    }

    public static RoomWebService getInstance() {
        if (roomWebService == null) {
            roomWebService = new RoomWebService();
        }

        return roomWebService;
    }
}
