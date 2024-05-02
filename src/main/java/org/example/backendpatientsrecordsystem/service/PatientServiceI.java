package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.exceptions.EmailValidator;
import org.example.backendpatientsrecordsystem.exceptions.PatientNotFoundException;
import org.example.backendpatientsrecordsystem.exceptions.WrongMobileException;
import org.example.backendpatientsrecordsystem.models.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientServiceI {
    public Patient addorUpdatePatient(Patient patient) ;

    public Patient getPatientById(Long Id) ;

    public void deletePatientById(Long patientId) ;

    public List<Patient> getAllPatients() ;

    public boolean isValidEmail(String email) ;
}
