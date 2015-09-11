package com.openhabbo.communication.events.room.furniture;

import com.openhabbo.communication.events.AbstractMessageEvent;
import com.openhabbo.communication.parsers.room.furniture.CreditFurniRedeemMessageParser;

import java.util.function.Consumer;

public class CreditFurniRedeemMessageEvent extends AbstractMessageEvent<CreditFurniRedeemMessageParser> {

    public CreditFurniRedeemMessageEvent(Consumer<CreditFurniRedeemMessageParser> callback) {
        super(callback, CreditFurniRedeemMessageParser.class);
    }
}
