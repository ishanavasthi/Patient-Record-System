package org.example.backendpatientsrecordsystem.controllers;

import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
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
}