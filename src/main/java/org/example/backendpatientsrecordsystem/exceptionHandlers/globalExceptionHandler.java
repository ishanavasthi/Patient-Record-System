package org.example.backendpatientsrecordsystem.exceptionHandlers;

import org.example.backendpatientsrecordsystem.DTOs.ExceptionDto;
import org.example.backendpatientsrecordsystem.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice


public class globalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic Exception");
        exceptionDto.setResolution("Check the arithmetic operation and try again");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleIndexOutOfBoundException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Index Out Of Bound Exception");
        exceptionDto.setResolution("Check and try again");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Exception! Something went wrong! Check the DOB");
        exceptionDto.setResolution("Please try again later");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
    @ExceptionHandler(WrongDOBException.class)
    public ResponseEntity<ExceptionDto> handleWrongDOBException(WrongDOBException e) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Wrong Date of Birth Exception");
        exceptionDto.setResolution("Please enter a valid date of birth in YYYY-MM-DD format");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(WrongMobileException.class)
    public ResponseEntity<ExceptionDto> handleWrongMobileException(WrongMobileException e) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Wrong Mobile Number Exception");
        exceptionDto.setResolution("Please enter a valid mobile number of 10 digits");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleAppointmentNotFoundException(AppointmentNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Appointment Not Found Exception");
        exceptionDto.setResolution("Please enter a valid appointment id");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(MedicalHistoryNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleMedicalHistoryNotFoundException(MedicalHistoryNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Medical History Not Found Exception");
        exceptionDto.setResolution("Please enter a valid medical history id");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ExceptionDto> handlePatientNotFoundException(PatientNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Patient Not Found Exception");
        exceptionDto.setResolution("Please enter a valid patient id");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(EmailValidator.class)
    public ResponseEntity<ExceptionDto> handleEmailValidator(EmailValidator e) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Email Validator Exception");
        exceptionDto.setResolution("Please enter a valid email address");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}

