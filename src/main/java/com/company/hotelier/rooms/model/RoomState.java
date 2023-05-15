package com.company.hotelier.rooms.model;

import java.util.Arrays;

public enum RoomState {

    AVAILABLE(1),
    RESERVED(2),
    IN_RENOVATION(3),
    NOT_AVAILABLE(4);

    private final int state;

    RoomState(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    public static RoomState values(int state) {
        return Arrays.stream(RoomState.values())
                .filter(roomState -> roomState.getState() == state)
                .findFirst()
                .orElse(NOT_AVAILABLE);
    }
}
