package org.example.backendpatientsrecordsystem.exceptions;

public class WrongMobileException extends RuntimeException{
    private String mobile;

    public WrongMobileException(String mobile, String message){
        super(message);
        this.mobile = mobile;
    }
}
