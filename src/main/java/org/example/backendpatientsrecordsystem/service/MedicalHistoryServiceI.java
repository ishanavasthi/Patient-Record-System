package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.exceptions.MedicalHistoryNotFoundException;
import org.example.backendpatientsrecordsystem.models.MedicalHistory;
import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.repositories.MedicalHistoryRepository;
import org.example.backendpatientsrecordsystem.repositories.PatientRepository;

import java.util.List;

public interface MedicalHistoryServiceI {

    public MedicalHistory getMedicalHistoryById(Long medicalHistoryId) ;

    public MedicalHistory addOrUpdateMedicalHistory(MedicalHistory medicalHistory) ;

    public void deleteMedicalHistoryById(Long medicalHistoryId) ;

    public List<MedicalHistory> getMedicalHistoryListByPatientId(Long patientId);
}
