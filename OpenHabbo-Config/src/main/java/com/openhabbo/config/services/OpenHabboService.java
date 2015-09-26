package com.openhabbo.config.services;

import java.util.List;

public class OpenHabboService {
    private final String alias;
    private final String url;

    public OpenHabboService(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public String getUrl() {
        return url;
    }

    public static OpenHabboService create(String data) {
        String[] splitData = data.split("://");

        return new OpenHabboService(splitData[0], splitData[1]);
    }
}
