package org.example.backendpatientsrecordsystem.exceptions;

public class AppointmentNotFoundException extends RuntimeException{
    private Long id;

    public AppointmentNotFoundException(Long id, String message){
        super(message);
        this.id = id;
    }
}
