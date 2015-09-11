package com.openhabbo.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OpenHabboPeerServiceConfiguration {
    private static final Logger log = LogManager.getLogger(OpenHabboPeerServiceConfiguration.class);

    private final int servicePort;

    // Game Configuration
    private final List<Integer> gamePorts;

    public OpenHabboPeerServiceConfiguration(int servicePort, List<Integer> gamePorts) {
        this.servicePort = servicePort;
        this.gamePorts = gamePorts;
    }

    public static OpenHabboPeerServiceConfiguration loadConfiguration() {
        final Config config = ConfigFactory.load("openhabbo-peerservice.conf");

        final int servicePort = config.getInt("openhabbo-peerService.servicePort");
        final List<Integer> gamePorts = config.getIntList("openhabbo-peerService.game.ports");

        log.debug("Peer service configuration loaded; service port: {}, game ports: {}",
                servicePort, gamePorts);

        return new OpenHabboPeerServiceConfiguration(servicePort, gamePorts);
    }

    public List<Integer> getGamePorts() {
        return gamePorts;
    }

    public int getServicePort() {
        return servicePort;
    }
}
