package com.openhabbo.communication.composers.friendlist;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class MessengerInitMessageComposer extends AbstractMessageComposer {
    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeInteger(300);
        data.writeInteger(300);
        data.writeInteger(800);
        data.writeInteger(1100);
        data.writeInteger(0);
        data.writeInteger(0);//friends count
    }
}
