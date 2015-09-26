package com.openhabbo.peer;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.peer.PeerSendMessage;
import com.openhabbo.communication.composers.AbstractMessageComposer;
import com.openhabbo.config.OpenHabboPeerServiceConfiguration;
import com.openhabbo.config.OpenHabboServiceConfiguration;
import com.openhabbo.peer.networking.GameNetworkService;
import com.openhabbo.peer.web.PeerWebService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;


public class OpenHabboPeerService {
    private final Logger log = LogManager.getLogger(OpenHabboPeerService.class);

    private static OpenHabboPeerService peerServiceInstance;

    private String[] runtimeArguments;

    private OpenHabboServiceConfiguration serviceConfiguration;
    private OpenHabboPeerServiceConfiguration peerServiceConfiguration;

    private GameNetworkService gameNetworkService;

    public OpenHabboPeerService() {
    }

    public void initialize(final String[] runtimeArguments) {
        this.runtimeArguments = runtimeArguments;

        this.log.info("Initializing OpenHabbo Peer Service");

        // load configuration.
        this.serviceConfiguration = OpenHabboServiceConfiguration.loadConfiguration();
        this.peerServiceConfiguration = OpenHabboPeerServiceConfiguration.loadConfiguration();

        // initialize game network service
        this.log.info("Initializing game network service");
        this.gameNetworkService = new GameNetworkService(this.peerServiceConfiguration);
        this.gameNetworkService.initialize();

        // initialize web service
        this.log.info("Initializing web service");
        WebClient.getInstance().initialize(this.serviceConfiguration);
        PeerWebService.getInstance().initialize();
    }

    public OpenHabboServiceConfiguration getServiceConfiguration() {
        return serviceConfiguration;
    }

    public OpenHabboPeerServiceConfiguration getPeerServiceConfiguration() {
        return peerServiceConfiguration;
    }

    public String[] getRuntimeArguments() {
        return runtimeArguments;
    }

    public static void main(String[] args) {
        OpenHabboPeerService.getInstance().initialize(args);
    }

    public static OpenHabboPeerService getInstance() {
        if (peerServiceInstance == null) {
            peerServiceInstance = new OpenHabboPeerService();
        }

        return peerServiceInstance;
    }
}
