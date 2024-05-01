package org.example.backendpatientsrecordsystem.exceptions;

public class WrongDOBException extends RuntimeException{
    private String dob;

    public WrongDOBException(String dob, String message){
        super(message);
        this.dob = dob;
    }
}
