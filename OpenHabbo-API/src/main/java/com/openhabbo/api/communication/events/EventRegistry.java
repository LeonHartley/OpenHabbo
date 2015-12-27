package com.openhabbo.api.communication.events;

public interface EventRegistry {
    void registerEvent(MessageEvent event);

    void unregisterEvent(Class<? extends MessageEvent> eventClass);
}
