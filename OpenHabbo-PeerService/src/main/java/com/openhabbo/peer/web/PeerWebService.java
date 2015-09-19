package com.openhabbo.peer.web;

import com.openhabbo.commons.logging.JettyLogger;
import com.openhabbo.commons.web.DefaultWebServiceFilters;
import com.openhabbo.peer.OpenHabboPeerService;
import org.eclipse.jetty.util.log.Log;
import spark.Spark;

import static spark.Spark.get;

public class PeerWebService {
    private static PeerWebService peerWebService;

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
    }

    public static PeerWebService getInstance() {
        if (peerWebService == null) {
            peerWebService = new PeerWebService();
        }

        return peerWebService;
    }
}
