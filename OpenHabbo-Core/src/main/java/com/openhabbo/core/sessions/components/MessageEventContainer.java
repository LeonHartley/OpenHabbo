package com.openhabbo.core.sessions.components;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.events.EventHandler;
import com.openhabbo.api.communication.events.EventRegistry;
import com.openhabbo.api.communication.events.MessageEvent;
import com.openhabbo.api.communication.headers.MessageHeaderProviderService;
import com.openhabbo.commons.collections.CollectionsUtil;
import com.openhabbo.core.sessions.PlayerSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageEventContainer implements EventHandler, EventRegistry {
    private static final Logger log = LogManager.getLogger(MessageEventContainer.class);

    private Map<Short, List<MessageEvent>> messageListeners;
    private Map<Class, Short> classToHeader;

    private PlayerSession playerSession;

    public MessageEventContainer(PlayerSession playerSession) {
        this.playerSession = playerSession;

        this.messageListeners = new ConcurrentHashMap<>();
        this.classToHeader = new ConcurrentHashMap<>();
    }

    @Override
    public void registerEvent(MessageEvent messageEvent) {
        final short messageHeader = MessageHeaderProviderService.getProvider().getHeaderByEventClass(messageEvent.getClass());

        if (this.messageListeners.containsKey(messageHeader)) {
            this.messageListeners.get(messageHeader).add(messageEvent);
        } else {
            this.messageListeners.put(messageHeader, CollectionsUtil.createList(messageEvent));
        }

        if (!this.classToHeader.containsKey(messageEvent.getClass())) {
            this.classToHeader.put(messageEvent.getClass(), messageHeader);
        }
    }

    public void unregisterAllEvents() {
        for (List<MessageEvent> messageEvents : this.messageListeners.values()) {
            messageEvents.clear();
        }

        this.messageListeners.clear();
        this.classToHeader.clear();
    }

    @Override
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

    @Override
    public void handleEvent(short headerId, IncomingMessageWrapper messageWrapper) {
        if(!this.messageListeners.containsKey(headerId)) {
            return;
        }

        List<MessageEvent> events = this.messageListeners.get(headerId);

        for(MessageEvent event : events) {
            try {
                event.onComplete(messageWrapper);
            } catch(Exception e) {
                // todo: log
                e.printStackTrace();
            }
        }
    }

    public PlayerSession getPlayerSession() {
        return playerSession;
    }
}
