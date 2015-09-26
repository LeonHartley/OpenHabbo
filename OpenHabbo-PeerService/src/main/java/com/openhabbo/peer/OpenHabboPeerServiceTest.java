package com.openhabbo.peer;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.openhabbo.api.communication.data.OutgoingMessageWrapper;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.commons.web.requests.peer.PeerSendMessage;
import com.openhabbo.communication.composers.AbstractMessageComposer;
import com.openhabbo.config.OpenHabboServiceConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;


public class OpenHabboPeerServiceTest {
    private final Logger log = LogManager.getLogger(OpenHabboPeerService.class);

    private OpenHabboServiceConfiguration serviceConfiguration;
    public void initialize(final String[] runtimeArguments) {

        this.log.info("Initializing OpenHabbo Peer Service");

        this.serviceConfiguration = OpenHabboServiceConfiguration.loadConfiguration();

        WebClient.getInstance().initialize(this.serviceConfiguration);

        WebClient.getInstance().dispatchRequest("peerservice-1",
                new PeerSendMessage(UUID.randomUUID(), new TestMessageComposer("Leon H")));
    }

    private class TestMessageComposer extends AbstractMessageComposer {
        private String username;

        public TestMessageComposer(String username) {
            this.username = username;
        }

        @Override
        public void onCompose(OutgoingMessageWrapper data) {
            System.out.println("TOP KEK LOL IT WORKS");
        }

        public String getUsername() {
            return this.username;
        }
    }

    public static void main(String[] args) {
        new OpenHabboPeerServiceTest().initialize(args);
    }

}
