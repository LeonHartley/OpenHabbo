package com.openhabbo.api.communication.headers;

public interface MessageHeaderProvider {
    short getHeaderByEventClass(Class eventClass);

    short getHeaderByComposerClass(Class composerClass);

    Class getEventClassByHeader(short header);

    Class getComposerClassByHeader(short header);
}
