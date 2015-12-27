package com.openhabbo.communication.composers.notifications;

import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.communication.composers.AbstractMessageComposer;

public class HabboActivityPointNotificationMessageComposer extends AbstractMessageComposer {

    private final int activityPoints;
    private final int activityPointsNotif;

    public HabboActivityPointNotificationMessageComposer(final int activityPoints) {
        this.activityPoints = activityPoints;
        this.activityPointsNotif = 0;
    }

    public HabboActivityPointNotificationMessageComposer(final int activityPoints, final int activityPointsNotif) {
        this.activityPoints = activityPoints;
        this.activityPointsNotif = activityPointsNotif;
    }

    @Override
    public void onCompose(OutgoingMessageWrapper data) {
        data.writeInteger(this.activityPoints);
        data.writeInteger(this.activityPointsNotif);
    }
}
