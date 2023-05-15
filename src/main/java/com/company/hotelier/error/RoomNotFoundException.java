package com.company.hotelier.error;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(){
        super();
    }

    public RoomNotFoundException(String message){
        super(message);
    }
}
