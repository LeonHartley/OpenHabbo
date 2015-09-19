package com.openhabbo.api.communication.composers;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;

public interface MessageComposer {
    void onCompose(OutgoingMessageWrapper data);
}
