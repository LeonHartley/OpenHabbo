package com.openhabbo.communication.services.messages;

import com.mashape.unirest.http.JsonNode;
import com.openhabbo.communication.services.messages.handlers.GenericMessageHandler;
import io.netty.channel.Channel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ServiceCommunicationMessageHandler {
    private static ServiceCommunicationMessageHandler instance;

    private final Logger log = LogManager.getLogger(ServiceCommunicationMessageHandler.class);

    private final Map<String, Consumer<MessageArgs>> messages;

    public ServiceCommunicationMessageHandler() {
        this.messages = new ConcurrentHashMap<>();

        this.messages.put("hello", GenericMessageHandler::hello);
    }

    public void handleMessage(String data, Channel channel) {
        try {
            final JsonNode jsonNode = new JsonNode(data);
            final String messageId = jsonNode.getObject().getString("id");

            if (this.messages.containsKey(messageId)) {
                this.messages.get(messageId).accept(new MessageArgs(channel, data));
            }
        } catch(Exception e) {
            log.error("Error while handling ServiceCommunication message", e);
        }
    }

    public static ServiceCommunicationMessageHandler getInstance() {
        if(instance == null) {
            instance = new ServiceCommunicationMessageHandler();
        }

        return instance;
    }
}
