package com.company.hotelier.error;

public class StaffNotFoundException extends RuntimeException{

    public StaffNotFoundException(){
        super();
    }

    public StaffNotFoundException(String message){
        super(message);
    }
}
