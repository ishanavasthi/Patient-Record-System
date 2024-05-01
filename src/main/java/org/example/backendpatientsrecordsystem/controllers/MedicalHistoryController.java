package org.example.backendpatientsrecordsystem.controllers;

import org.example.backendpatientsrecordsystem.models.MedicalHistory;
import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.service.MedicalHistoryService;
import org.example.backendpatientsrecordsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-histories")
public class MedicalHistoryController {

    private final MedicalHistoryService medicalHistoryService;

    @Autowired
    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

//    @PostMapping("/")

    @PutMapping("/")
    public ResponseEntity<MedicalHistory> addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        // Validate input (e.g., check if patient ID is provided)
        // You can also perform additional business logic here

        MedicalHistory savedMedicalHistory = medicalHistoryService.addOrUpdateMedicalHistory(medicalHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedicalHistory);
    }

    @GetMapping("/{medicalHistoryId}")
    public ResponseEntity<MedicalHistory> getMedicalHistoryById(@PathVariable Long medicalHistoryId) {
        MedicalHistory medicalHistory = medicalHistoryService.getMedicalHistoryById(medicalHistoryId);
        return ResponseEntity.ok(medicalHistory);
    }

    @DeleteMapping("/{medicalHistoryId}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long medicalHistoryId) {
        medicalHistoryService.deleteMedicalHistoryById(medicalHistoryId);
        return ResponseEntity.noContent().build();
    }
}
