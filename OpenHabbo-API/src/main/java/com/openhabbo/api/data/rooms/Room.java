package com.openhabbo.api.data.rooms;

import com.openhabbo.api.data.rooms.util.RoomAccessType;

public class Room {
    private int id;
    private String name;
    private String description;
    private int playerId;
    private String playerName;
    private RoomAccessType accessType;
    private String password;
    private int rating;
    private String model;
    private boolean allowPets;
    private boolean allowPetsEating;
    private boolean disableBlocking;
    private String decorations;
    private String icon;

    public Room(int id, String name, String description, int playerId, String playerName, RoomAccessType accessType, String password, int rating, String model, boolean allowPets, boolean allowPetsEating, boolean disableBlocking, String decorations, String icon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.playerId = playerId;
        this.playerName = playerName;
        this.accessType = accessType;
        this.password = password;
        this.rating = rating;
        this.model = model;
        this.allowPets = allowPets;
        this.allowPetsEating = allowPetsEating;
        this.disableBlocking = disableBlocking;
        this.decorations = decorations;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public RoomAccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(RoomAccessType accessType) {
        this.accessType = accessType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAllowPets() {
        return allowPets;
    }

    public void setAllowPets(boolean allowPets) {
        this.allowPets = allowPets;
    }

    public boolean isAllowPetsEating() {
        return allowPetsEating;
    }

    public void setAllowPetsEating(boolean allowPetsEating) {
        this.allowPetsEating = allowPetsEating;
    }

    public boolean isDisableBlocking() {
        return disableBlocking;
    }

    public void setDisableBlocking(boolean disableBlocking) {
        this.disableBlocking = disableBlocking;
    }

    public String getDecorations() {
        return decorations;
    }

    public void setDecorations(String decorations) {
        this.decorations = decorations;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
