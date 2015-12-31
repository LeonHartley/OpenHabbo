package com.openhabbo.config;

import com.openhabbo.config.services.OpenHabboService;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenHabboServiceConfiguration {
    private static final Logger log = LogManager.getLogger(OpenHabboServiceConfiguration.class);

    private final OpenHabboService masterService;

    private final Map<String, OpenHabboService> peerServices;
    private final Map<String, OpenHabboService> storageServices;
    private final Map<String, OpenHabboService> roomServices;

    private final String authenticationToken;

    private final List<String> allowedIpAddresses;
    public OpenHabboServiceConfiguration(OpenHabboService masterService,
                                         Map<String, OpenHabboService> peerServices,
                                         Map<String, OpenHabboService> storageServices,
                                         Map<String, OpenHabboService> roomServices,
                                         String authenticationToken,
                                         List<String> allowedIpAddresses) {
        this.masterService = masterService;
        this.peerServices = peerServices;
        this.storageServices = storageServices;
        this.roomServices = roomServices;
        this.authenticationToken = authenticationToken;
        this.allowedIpAddresses = allowedIpAddresses;
    }

    public static OpenHabboServiceConfiguration loadConfiguration() {
        final Config config = ConfigFactory.load("openhabbo.conf");

        final String masterService = config.getString("openhabbo-services.masterService");

        final List<String> peerServiceData = config.getStringList("openhabbo-services.peerServices");
        final List<String> storageServiceData = config.getStringList("openhabbo-services.storageServices");
        final List<String> roomServiceData = config.getStringList("openhabbo-services.roomServices");

        final String authenticationToken = config.getString("openhabbo-services.security.authenticationToken");
        final List<String> allowedIpAddresses = config.getStringList("openhabbo-services.security.allowedIpAddresses");

        final Map<String, OpenHabboService> peerServices = new HashMap<>();
        final Map<String, OpenHabboService> storageServices = new HashMap<>();
        final Map<String, OpenHabboService> roomServices = new HashMap<>();

        for (String peerService : peerServiceData) {
            OpenHabboService service = OpenHabboService.create(peerService);
            peerServices.put(service.getAlias(), service);
        }

        for (String storageService : storageServiceData) {
            OpenHabboService service = OpenHabboService.create(storageService);
            storageServices.put(service.getAlias(), service);
        }

        for (String roomService : roomServiceData) {
            OpenHabboService service = OpenHabboService.create(roomService);
            roomServices.put(service.getAlias(), service);
        }

        log.debug("Service configuration loaded, found " +
                        "{} peer service(s) and " +
                        "{} storage service(s) and " +
                        "{} room service(s)",
                peerServices.size(), storageServices.size(), roomServices.size());

        return new OpenHabboServiceConfiguration(OpenHabboService.create(masterService), peerServices, storageServices,
                roomServices, authenticationToken,
                allowedIpAddresses);
    }

    public Map<String, OpenHabboService> getPeerServices() {
        return peerServices;
    }

    public Map<String, OpenHabboService> getStorageServices() {
        return storageServices;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public List<String> getAllowedIpAddresses() {
        return allowedIpAddresses;
    }

    public OpenHabboService getMasterService() {
        return masterService;
    }

    public Map<String, OpenHabboService> getRoomServices() {
        return roomServices;
    }
}
