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
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final MedicalHistoryService medicalHistoryService;

    @Autowired
    public PatientController(PatientService patientService, MedicalHistoryService medicalHistoryService) {
        this.patientService = patientService;
        this.medicalHistoryService = medicalHistoryService;
    }

    @PostMapping("")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addorUpdatePatient(patient);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
        Patient patient = null;

        patient = patientService.getPatientById(patientId);
        ResponseEntity<Patient> responseEntity = new ResponseEntity<>(patient, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{patientId}/medical-histories")
    public ResponseEntity<List<MedicalHistory>> getMedicalHistoriesByPatientId(@PathVariable Long patientId) {
        List<MedicalHistory> medicalHistories = medicalHistoryService.getMedicalHistoryListByPatientId(patientId);
        return ResponseEntity.ok(medicalHistories);
    }
}