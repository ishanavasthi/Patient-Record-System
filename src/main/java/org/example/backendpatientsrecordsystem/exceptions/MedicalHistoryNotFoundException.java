package org.example.backendpatientsrecordsystem.exceptions;

public class MedicalHistoryNotFoundException extends RuntimeException {
    private Long id;

    public MedicalHistoryNotFoundException(Long id, String message){
        super(message);
        this.id = id;
    }
}
