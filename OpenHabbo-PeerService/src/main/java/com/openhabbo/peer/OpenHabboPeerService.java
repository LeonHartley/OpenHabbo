package com.openhabbo.peer;

import com.openhabbo.config.OpenHabboServiceConfiguration;

public class OpenHabboPeerService {
    private static OpenHabboPeerService peerServiceInstance;

    private String[] runtimeArguments;

    public OpenHabboPeerService() {

    }

    public void initialize(final String[] runtimeArguments) {
        this.runtimeArguments = runtimeArguments;

        // Load configuration.
        final OpenHabboServiceConfiguration serviceConfiguration = OpenHabboServiceConfiguration.loadConfiguration();
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
