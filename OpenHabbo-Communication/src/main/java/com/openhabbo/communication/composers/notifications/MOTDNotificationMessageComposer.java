package com.openhabbo.communication.composers.notifications;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class MOTDNotificationMessageComposer extends AbstractMessageComposer {

    private final String message;

    public MOTDNotificationMessageComposer(final String message) {
        this.message = message;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeBoolean(true);
        data.writeString(this.message);
    }
}
