package com.company.hotelierproject.rooms.error;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(){
        super();
    }

    public RoomNotFoundException(String message){
        super(message);
    }
}
