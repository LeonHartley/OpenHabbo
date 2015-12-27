package com.openhabbo.communication.composers.inventory.purse;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class CreditBalanceMessageComposer extends AbstractMessageComposer {

    private final int creditBalance;

    public CreditBalanceMessageComposer(final int creditBalance) {
        this.creditBalance = creditBalance;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeString(this.creditBalance + ".0");
    }
}
