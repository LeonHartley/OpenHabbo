package com.openhabbo.communication.services.messages.outgoing;

public abstract class Message {
    private String id;

    public Message(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
