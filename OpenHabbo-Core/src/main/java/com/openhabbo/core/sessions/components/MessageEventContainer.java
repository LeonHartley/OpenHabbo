package com.openhabbo.core.sessions.components;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.events.MessageEvent;
import com.openhabbo.api.communication.headers.MessageHeaderProviderService;
import com.openhabbo.commons.collections.CollectionsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageEventContainer {
    private static final Logger log = LogManager.getLogger(MessageEventContainer.class);

    private Map<Short, List<MessageEvent>> messageListeners;
    private Map<Class, Short> classToHeader;

    public MessageEventContainer() {
        this.messageListeners = new ConcurrentHashMap<>();
        this.classToHeader = new ConcurrentHashMap<>();
    }

    public void registerEvent(MessageEvent messageEvent) {
        final short messageHeader = MessageHeaderProviderService.getProvider().getHeaderByEventClass(messageEvent.getClass()); // Load header from somewhere..

        if (this.messageListeners.containsKey(messageHeader)) {
            this.messageListeners.get(messageHeader).add(messageEvent);
        } else {
            this.messageListeners.put(messageHeader, CollectionsUtil.createList(messageEvent));
        }

        if (!this.classToHeader.containsKey(messageEvent.getClass())) {
            this.classToHeader.put(messageEvent.getClass(), messageHeader);
        }

        try {
            // TODO: message
            messageEvent.onComplete(
                    new IncomingMessageWrapper() {
                        @Override
                        public String readString() {
                            return "yea-111";
                        }

                        @Override
                        public int readInteger() {
                            return 0;
                        }

                        @Override
                        public short readShort() {
                            return 0;
                        }

                        @Override
                        public boolean readBoolean() {
                            return false;
                        }

                        @Override
                        public byte readByte() {
                            return 0;
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unregisterAllEvents() {
        for (List<MessageEvent> messageEvents : this.messageListeners.values()) {
            messageEvents.clear();
        }

        this.messageListeners.clear();
        this.classToHeader.clear();
    }

    public void unregisterEvent(Class eventClass) {
        if (!this.classToHeader.containsKey(eventClass)) {
            return;
        }

        short header = this.classToHeader.get(eventClass);

        if (!this.messageListeners.containsKey(header)) {
            return;
        }

        log.info("Event {} was unregistered", eventClass.getName());
        this.messageListeners.get(header).clear();
        this.classToHeader.remove(eventClass);
    }
}
