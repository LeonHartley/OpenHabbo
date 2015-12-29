package com.openhabbo.peer.web;

import com.openhabbo.commons.logging.JettyLogger;
import com.openhabbo.commons.web.DefaultWebServiceFilters;
import com.openhabbo.commons.web.transformers.JsonTransformer;
import com.openhabbo.peer.OpenHabboPeerService;
import com.openhabbo.peer.web.requests.SessionRequests;
import org.eclipse.jetty.util.log.Log;
import spark.Spark;

import static spark.Spark.get;
import static spark.Spark.post;

public class PeerWebService {
    private static PeerWebService peerWebService;

    private final JsonTransformer jsonTransformer = new JsonTransformer();

    public PeerWebService() {
    }

    public void initialize() {
        Log.setLog(new JettyLogger());

        // configure the web service.
        Spark.port(OpenHabboPeerService.getInstance().getPeerServiceConfiguration().getServicePort());
        DefaultWebServiceFilters.apply(OpenHabboPeerService.getInstance().getServiceConfiguration());

        this.applyRoutes();
    }

    private void applyRoutes() {
        get("/", (req, res) -> "{\"response\":\"hi\"}");

        post("/session/:sessionId/sendMessage", SessionRequests::sendMessage, jsonTransformer);
    }

    public static PeerWebService getInstance() {
        if (peerWebService == null) {
            peerWebService = new PeerWebService();
        }

        return peerWebService;
    }
}
