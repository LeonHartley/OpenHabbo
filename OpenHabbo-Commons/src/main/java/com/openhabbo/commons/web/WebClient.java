package com.openhabbo.commons.web;

public class WebClient {
    private static WebClient webClient;

    public WebClient() {

    }

    public static WebClient getInstance() {
        if(webClient == null) {
            webClient = new WebClient();
        }

        return webClient;
    }
}
