package com.openhabbo.peer;

import com.openhabbo.config.OpenHabboPeerServiceConfiguration;
import com.openhabbo.config.OpenHabboServiceConfiguration;
import com.openhabbo.peer.networking.GameNetworkService;
import com.openhabbo.peer.networking.codec.encoding.Base64Codec;
import com.openhabbo.peer.web.PeerWebService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

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

        System.out.println(new String(Base64Codec.encodeInt("@@J@HHey!! :D".length(), 3)));

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
        PeerWebService.getInstance().initialize();
    }

    public String[] getRuntimeArguments() {
        return runtimeArguments;
    }

    public OpenHabboServiceConfiguration getServiceConfiguration() {
        return serviceConfiguration;
    }

    public OpenHabboPeerServiceConfiguration getPeerServiceConfiguration() {
        return peerServiceConfiguration;
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
