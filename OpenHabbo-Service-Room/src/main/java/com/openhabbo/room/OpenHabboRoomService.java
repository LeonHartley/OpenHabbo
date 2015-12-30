package com.openhabbo.room;

import com.openhabbo.api.services.OpenHabboService;
import com.openhabbo.commons.web.WebClient;
import com.openhabbo.communication.services.ServiceCommunicationManager;
import com.openhabbo.config.OpenHabboServiceConfiguration;
import com.openhabbo.room.web.RoomWebService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpenHabboRoomService {
    private final Logger log = LogManager.getLogger(OpenHabboRoomService.class);

    private static OpenHabboRoomService roomServiceInstance;

    private String[] runtimeArguments;
    private OpenHabboServiceConfiguration serviceConfiguration;

    private String serviceAlias = "roomservice-1";

    public OpenHabboRoomService() {

    }

    public void initialize(String[] runtimeArguments) {
        this.runtimeArguments = runtimeArguments;

        if (this.runtimeArguments.length != 0) {
            this.serviceAlias = this.runtimeArguments[0].replace("--alias:", "");
        }

        OpenHabboService.SERVICE_ALIAS = this.serviceAlias;
        OpenHabboService.SERVICE_TYPE = "room";

        this.log.info("Initializing OpenHabbo Room Service ({})", this.serviceAlias);

        // load configuration.
        this.serviceConfiguration = OpenHabboServiceConfiguration.loadConfiguration();

        // initialize web service
        this.log.info("Initializing web service");
        WebClient.getInstance().initialize(this.serviceConfiguration);
        RoomWebService.getInstance().initialize();

        // initialize master service connection
        log.info("Initializing master service connection");
        ServiceCommunicationManager.getInstance().initialize();
    }

    public static void main(String[] args) {
        OpenHabboRoomService.getInstance().initialize(args);
    }

    public static OpenHabboRoomService getInstance() {
        if (roomServiceInstance == null) {
            roomServiceInstance = new OpenHabboRoomService();
        }

        return roomServiceInstance;
    }

    public OpenHabboServiceConfiguration getServiceConfiguration() {
        return serviceConfiguration;
    }
}
