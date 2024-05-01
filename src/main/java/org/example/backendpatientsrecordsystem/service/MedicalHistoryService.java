package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.models.MedicalHistory;
import org.example.backendpatientsrecordsystem.repositories.MedicalHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryService {
    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    public MedicalHistory getMedicalHistoryById(Long medicalHistoryId) {
        return medicalHistoryRepository.findById(medicalHistoryId).orElseThrow(() -> new RuntimeException("Medical History not found"));
    }

    public MedicalHistory addOrUpdateMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    public void deleteMedicalHistoryById(Long medicalHistoryId) {
        medicalHistoryRepository.deleteById(medicalHistoryId);
    }
}