package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public Patient addorUpdatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if(optionalPatient.isEmpty()){
            throw new RuntimeException("Patient not found");
        }
        return optionalPatient.get();
    }



    public void deletePatientById(Long patientId) {
        patientRepository.deleteById(patientId);
    }
}