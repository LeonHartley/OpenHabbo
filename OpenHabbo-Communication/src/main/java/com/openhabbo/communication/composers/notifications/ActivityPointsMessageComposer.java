package com.openhabbo.communication.composers.notifications;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class ActivityPointsMessageComposer extends AbstractMessageComposer {

    private final int activityPoints;

    public ActivityPointsMessageComposer(final int activityPoints) {
        this.activityPoints = activityPoints;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        // TODO: shells n shit
        data.writeInteger(1); // amount

        // loop through currencies & balance.
        {
            data.writeInteger(0); // id of first currency
            data.writeInteger(this.activityPoints); // balance of currency.
        }
    }
}
