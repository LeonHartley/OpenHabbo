package com.openhabbo.commons.web;

import com.openhabbo.config.OpenHabboServiceConfiguration;

import static spark.Spark.*;

public class DefaultWebServiceFilters {

    public static void apply(OpenHabboServiceConfiguration config) {
        before((req, res) -> res.type("application/json"));

        before((req, res) -> {
            if(req.headers(WebClient.AUTHENTICATION_HEADER) == null || !req.headers(WebClient.AUTHENTICATION_HEADER).equals(config.getAuthenticationToken())) {
                res.type("application/json");
                halt(401, "{\"error\": \"Invalid authentication key\"}");
            }
        });
    }
}
