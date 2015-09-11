package com.openhabbo.api.communication.headers;

public class MessageHeaderProviderService {
    private static MessageHeaderProvider provider;

    public static void set(MessageHeaderProvider messageHeaderProvider) {
        provider = messageHeaderProvider;
    }

    public static MessageHeaderProvider getProvider() {
        return provider;
    }
}
