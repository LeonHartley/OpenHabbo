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

    private final Map<String, OpenHabboService> peerServices;
    private final Map<String, OpenHabboService> authServices;
    private final Map<String, OpenHabboService> accountServices;

    private final String authenticationToken;
    private final List<String> allowedIpAddresses;

    public OpenHabboServiceConfiguration(Map<String, OpenHabboService> peerServices, Map<String, OpenHabboService> authServices,
                                         Map<String, OpenHabboService> accountServices, String authenticationToken,
                                         List<String> allowedIpAddresses) {
        this.peerServices = peerServices;
        this.authServices = authServices;
        this.accountServices = accountServices;
        this.authenticationToken = authenticationToken;
        this.allowedIpAddresses = allowedIpAddresses;
    }

    public static OpenHabboServiceConfiguration loadConfiguration() {
        final Config config = ConfigFactory.load("openhabbo.conf");

        final List<String> peerServiceData = config.getStringList("openhabbo-services.peerServices");
        final List<String> authServiceData = config.getStringList("openhabbo-services.authServices");
        final List<String> accountServiceData = config.getStringList("openhabbo-services.accountServices");

        final String authenticationToken = config.getString("openhabbo-services.security.authenticationToken");
        final List<String> allowedIpAddresses = config.getStringList("openhabbo-services.security.allowedIpAddresses");

        final Map<String, OpenHabboService> peerServices = new HashMap<>();
        final Map<String, OpenHabboService> authServices = new HashMap<>();
        final Map<String, OpenHabboService> accountServices = new HashMap<>();

        for(String peerService : peerServiceData) {
            OpenHabboService service = OpenHabboService.create(peerService);
            peerServices.put(service.getAlias(), service);
        }

        for(String authService : authServiceData) {
            OpenHabboService service = OpenHabboService.create(authService);
            authServices.put(service.getAlias(), service);
        }

        for(String accountService : accountServiceData) {
            OpenHabboService service = OpenHabboService.create(accountService);
            accountServices.put(service.getAlias(), service);
        }

        log.debug("Service configuration loaded, found " +
                        "{} peer service(s), " +
                        "{} auth service(s) and " +
                        "{} account service(s).",
                peerServices.size(), authServices.size(), accountServices.size());

        return new OpenHabboServiceConfiguration(peerServices, authServices, accountServices, authenticationToken,
                allowedIpAddresses);
    }

    public Map<String, OpenHabboService> getPeerServices() {
        return peerServices;
    }

    public Map<String, OpenHabboService> getAuthServices() {
        return authServices;
    }

    public Map<String, OpenHabboService> getAccountServices() {
        return accountServices;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public List<String> getAllowedIpAddresses() {
        return allowedIpAddresses;
    }
}
