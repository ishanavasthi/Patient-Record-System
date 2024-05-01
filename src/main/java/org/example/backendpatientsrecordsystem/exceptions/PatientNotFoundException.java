package org.example.backendpatientsrecordsystem.exceptions;

public class PatientNotFoundException extends RuntimeException{


    public PatientNotFoundException(String message){
        super(message);

    }
}
