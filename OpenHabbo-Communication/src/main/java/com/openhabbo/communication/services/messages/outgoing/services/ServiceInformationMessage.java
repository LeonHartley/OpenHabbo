package com.openhabbo.communication.services.messages.outgoing.services;

import com.openhabbo.communication.services.messages.outgoing.Message;

public class ServiceInformationMessage extends Message {
    private String serviceType;
    private String serviceAlias;

    public ServiceInformationMessage(String serviceType, String serviceAlias) {
        super("serviceInformation");

        this.serviceType = serviceType;
        this.serviceAlias = serviceAlias;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getServiceAlias() {
        return serviceAlias;
    }
}
