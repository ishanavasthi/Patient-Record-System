package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.exceptions.EmailValidator;
import org.example.backendpatientsrecordsystem.exceptions.PatientNotFoundException;
import org.example.backendpatientsrecordsystem.exceptions.WrongMobileException;
import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }
    public Patient addorUpdatePatient(Patient patient) {
        if(patient.getContactNumber().length() != 10){
            throw new WrongMobileException("Wrong Mobile Number", patient.getContactNumber());
        }
        String email = patient.getEmail();

        if(!isValidEmail(email)){
            throw new EmailValidator(email, "Invalid Email");
        }

        // DONT REMOVE THIS COMMENT PLEASE BHAIYO
//        if(patient.getId() == null){
//            throw new PatientNotFoundException("Patient not found");
//        }

        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long Id) {
        Optional<Patient> optionalPatient = patientRepository.findById(Id);
        if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        return optionalPatient.get();
    }



    public void deletePatientById(Long patientId) {
        if (!patientRepository.existsById(patientId)) {
            throw new PatientNotFoundException("Patient not found");
        }
        patientRepository.deleteById(patientId);
    }

    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}