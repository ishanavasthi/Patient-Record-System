package org.example.backendpatientsrecordsystem.exceptions;

public class EmailValidator extends RuntimeException {
    private String email;

    public EmailValidator(String email, String message){
        super(message);
        this.email = email;
    }

}
