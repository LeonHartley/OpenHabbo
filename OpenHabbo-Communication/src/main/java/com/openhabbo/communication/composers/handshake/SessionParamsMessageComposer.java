package com.openhabbo.communication.composers.handshake;

import com.openhabbo.api.communication.composers.MessageComposer;
import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class SessionParamsMessageComposer extends AbstractMessageComposer {
    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeInteger(9);
        data.writeInteger(0);
        data.writeInteger(0);
        data.writeInteger(1);
        data.writeInteger(1);
        data.writeInteger(3);
        data.writeInteger(0);
        data.writeInteger(2);
        data.writeInteger(0);
        data.writeInteger(4);
        data.writeInteger(1);
        data.writeInteger(5);
        data.writeString("dd-MM-yyyy");
        data.writeInteger(7);
        data.writeInteger(0);
        data.writeInteger(8);
        data.writeString("http://hotel-us");
        data.writeInteger(9);
        data.writeInteger(0);
    }
}
