package com.openhabbo.communication.services.messages.handlers;

import com.openhabbo.api.services.OpenHabboService;
import com.openhabbo.commons.json.JsonUtil;
import com.openhabbo.communication.services.messages.MessageArgs;
import com.openhabbo.communication.services.messages.outgoing.services.ServiceInformationMessage;

public class GenericMessageHandler {
    public static void hello(MessageArgs messageArgs) {
        messageArgs.getChannel().writeAndFlush(JsonUtil.stringify(
                new ServiceInformationMessage(OpenHabboService.SERVICE_TYPE, OpenHabboService.SERVICE_ALIAS)));
    }
}
