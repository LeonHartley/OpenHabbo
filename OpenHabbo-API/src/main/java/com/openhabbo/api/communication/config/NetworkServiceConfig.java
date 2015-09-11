package com.openhabbo.api.communication.config;

public interface NetworkServiceConfig {
    String getHost();

    int[] getPorts();

    int getMaxConnections();

    int getMaxConnectionsPerAddress();
}
