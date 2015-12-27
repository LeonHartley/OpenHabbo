package com.openhabbo.communication.events;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;
import com.openhabbo.api.communication.events.MessageEvent;
import com.openhabbo.communication.parsers.AbstractMessageParser;

import java.util.function.Consumer;

public abstract class AbstractMessageEvent<T extends AbstractMessageParser> implements MessageEvent {
    private final Consumer<T> callback;
    private final Class<T> parser;

    public AbstractMessageEvent(Consumer<T> callback, Class<T> parser) {
        this.callback = callback;
        this.parser = parser;
    }

    @Override
    public boolean onComplete(IncomingMessageWrapper data) throws Exception {
        T parser = this.parser.newInstance();

        if(!parser.parse(data)) {
            return false;
        }

        this.callback.accept(parser);
        return true;
    }
}
