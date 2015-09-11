package com.openhabbo.api.communication.events;

import com.openhabbo.api.communication.data.IncomingMessageWrapper;

public interface MessageEvent {
    boolean onComplete(IncomingMessageWrapper data) throws Exception;
}
