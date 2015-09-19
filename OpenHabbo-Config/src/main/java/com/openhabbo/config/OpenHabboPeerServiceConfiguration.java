package com.openhabbo.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OpenHabboPeerServiceConfiguration {
    private static final Logger log = LogManager.getLogger(OpenHabboPeerServiceConfiguration.class);

    private final int servicePort;

    // Game Networking Configuration
    private final String gameAddress;
    private final List<Integer> gamePorts;

    private final boolean useEpoll;
    private final int backlog;

    private final int acceptGroupThreads;
    private final int ioGroupThreads;
    private final int channelGroupThreads;

    public OpenHabboPeerServiceConfiguration(int servicePort, String gameAddress, List<Integer> gamePorts, boolean useEpoll,
                                             int backlog, int acceptGroupThreads, int ioGroupThreads, int channelGroupThreads) {
        this.servicePort = servicePort;
        this.gameAddress = gameAddress;
        this.gamePorts = gamePorts;
        this.useEpoll = useEpoll;
        this.backlog = backlog;
        this.acceptGroupThreads = acceptGroupThreads;
        this.ioGroupThreads = ioGroupThreads;
        this.channelGroupThreads = channelGroupThreads;
    }

    public static OpenHabboPeerServiceConfiguration loadConfiguration() {
        final Config config = ConfigFactory.load("openhabbo-peerservice.conf");

        final int servicePort = config.getInt("openhabbo-peerService.servicePort");
        final String gameAddress = config.getString("openhabbo-peerService.game.address");
        final List<Integer> gamePorts = config.getIntList("openhabbo-peerService.game.ports");

        final boolean useEpoll = config.getBoolean("openhabbo-peerService.game.useEpoll");
        final int backlog = config.getInt("openhabbo-peerService.game.backlog");

        final int acceptGroupThreads = config.getInt("openhabbo-peerService.game.acceptGroupThreads");
        final int ioGroupThreads = config.getInt("openhabbo-peerService.game.ioGroupThreads");
        final int channelGroupThreads = config.getInt("openhabbo-peerService.game.channelGroupThreads");

        log.debug("Peer service configuration loaded; service port: {}, game ports: {}",
                servicePort, gamePorts);

        return new OpenHabboPeerServiceConfiguration(servicePort, gameAddress, gamePorts, useEpoll, backlog, acceptGroupThreads,
                ioGroupThreads, channelGroupThreads);
    }

    public String getGameAddress() {
        return gameAddress;
    }

    public List<Integer> getGamePorts() {
        return gamePorts;
    }

    public int getServicePort() {
        return servicePort;
    }

    public boolean useEpoll() {
        return useEpoll;
    }

    public int getAcceptGroupThreads() {
        return acceptGroupThreads;
    }

    public int getIoGroupThreads() {
        return ioGroupThreads;
    }

    public int getChannelGroupThreads() {
        return channelGroupThreads;
    }

    public int getBacklog() {
        return backlog;
    }
}
