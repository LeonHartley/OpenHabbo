package com.openhabbo.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OpenHabboServiceConfiguration {
    private static final Logger log = LogManager.getLogger(OpenHabboServiceConfiguration.class);

    private final List<String> peerServices;
    private final List<String> authServices;
    private final List<String> accountServices;

    private final String authenticationToken;
    private final List<String> allowedIpAddresses;

    public OpenHabboServiceConfiguration(List<String> peerServices, List<String> authServices,
                                         List<String> accountServices, String authenticationToken,
                                         List<String> allowedIpAddresses) {
        this.peerServices = peerServices;
        this.authServices = authServices;
        this.accountServices = accountServices;
        this.authenticationToken = authenticationToken;
        this.allowedIpAddresses = allowedIpAddresses;
    }

    public static OpenHabboServiceConfiguration loadConfiguration() {
        final Config config = ConfigFactory.load("openhabbo.conf");

        final List<String> peerServices = config.getStringList("openhabbo-services.peerServices");
        final List<String> authServices = config.getStringList("openhabbo-services.authServices");
        final List<String> accountServices = config.getStringList("openhabbo-services.accountServices");

        final String authenticationToken = config.getString("openhabbo-services.security.authenticationToken");
        final List<String> allowedIpAddresses = config.getStringList("openhabbo-services.security.allowedIpAddresses");

        log.debug("Service configuration loaded, found " +
                        "{} peer service(s), " +
                        "{} auth service(s) and " +
                        "{} account service(s).",
                peerServices.size(), authServices.size(), accountServices.size());

        return new OpenHabboServiceConfiguration(peerServices, authServices, accountServices, authenticationToken,
                allowedIpAddresses);
    }

    public List<String> getPeerServices() {
        return peerServices;
    }

    public List<String> getAuthServices() {
        return authServices;
    }

    public List<String> getAccountServices() {
        return accountServices;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public List<String> getAllowedIpAddresses() {
        return allowedIpAddresses;
    }
}
