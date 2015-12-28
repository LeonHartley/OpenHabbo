package com.openhabbo.api.data.rooms.util;

public enum RoomAccessType {
    OPEN,
    LOCKED,
    PASSWORD;

    public static int intValue(RoomAccessType type) {
        switch(type) {
            case OPEN: return 0;
            case LOCKED: return 1;
            case PASSWORD: return 2;
        }

        return 0;
    }
}
