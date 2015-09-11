package com.openhabbo.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OpenHabboServiceConfiguration {
    private static final Logger log = LogManager.getLogger(OpenHabboServiceConfiguration.class);
    private List<String> peerServices;
    private List<String> authServices;
    private List<String> accountServices;

    public OpenHabboServiceConfiguration(List<String> peerServices, List<String> authServices,
                                         List<String> accountServices) {
        this.peerServices = peerServices;
        this.authServices = authServices;
        this.accountServices = accountServices;
    }

    public static OpenHabboServiceConfiguration loadConfiguration() {
        final Config config = ConfigFactory.load("openhabbo.conf");

        final List<String> peerServices = config.getStringList("openhabbo-services.peerServices");
        final List<String> authServices = config.getStringList("openhabbo-services.authServices");
        final List<String> accountServices = config.getStringList("openhabbo-services.accountServices");

        log.debug("Service configuration loaded, found {} peer service(s), {} auth service(s) and {} account service(s).",
                peerServices.size(), authServices.size(), accountServices.size());

        return new OpenHabboServiceConfiguration(peerServices, authServices, accountServices);
    }

    public List<String> getPeerServices() {
        return peerServices;
    }

    public void setPeerServices(List<String> peerServices) {
        this.peerServices = peerServices;
    }

    public List<String> getAuthServices() {
        return authServices;
    }

    public void setAuthServices(List<String> authServices) {
        this.authServices = authServices;
    }

    public List<String> getAccountServices() {
        return accountServices;
    }

    public void setAccountServices(List<String> accountServices) {
        this.accountServices = accountServices;
    }
}
