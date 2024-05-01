package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.models.MedicalHistory;
import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.repositories.MedicalHistoryRepository;
import org.example.backendpatientsrecordsystem.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService {
    private final MedicalHistoryRepository medicalHistoryRepository;
    private final PatientRepository patientRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository, PatientRepository patientRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.patientRepository = patientRepository;
    }

    public MedicalHistory getMedicalHistoryById(Long medicalHistoryId) {
        return medicalHistoryRepository.findById(medicalHistoryId).orElseThrow(() -> new RuntimeException("Medical History not found"));
    }

    public MedicalHistory addOrUpdateMedicalHistory(MedicalHistory medicalHistory) {
        Patient patient = medicalHistory.getPatient();

        if (patient.getId() == null) {

            patient = patientRepository.save(patient);
            medicalHistory.setPatient(patient);
        }

        return medicalHistoryRepository.save(medicalHistory);
    }

    public void deleteMedicalHistoryById(Long medicalHistoryId) {
        medicalHistoryRepository.deleteById(medicalHistoryId);
    }


    public List<MedicalHistory> getMedicalHistoryListByPatientId(Long patientId) {
        return medicalHistoryRepository.findAllByPatientPatientId(patientId);
    }
}