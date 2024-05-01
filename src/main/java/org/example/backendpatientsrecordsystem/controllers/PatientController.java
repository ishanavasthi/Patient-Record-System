package org.example.backendpatientsrecordsystem.controllers;

import org.example.backendpatientsrecordsystem.exceptions.PatientNotFoundException;
import org.example.backendpatientsrecordsystem.models.Appointment;
import org.example.backendpatientsrecordsystem.models.MedicalHistory;
import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.service.AppointmentService;
import org.example.backendpatientsrecordsystem.service.MedicalHistoryService;
import org.example.backendpatientsrecordsystem.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;
    private final MedicalHistoryService medicalHistoryService;
    private final AppointmentService appointmentService;

    @Autowired
    public PatientController(PatientService patientService, MedicalHistoryService medicalHistoryService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.medicalHistoryService = medicalHistoryService;
        this.appointmentService = appointmentService;
    }

    @PutMapping("")
    public Patient addPatient(@RequestBody Patient patient) {
        logger.info("Creating/Updating patient with name {}", patient.getName());

        return patientService.addorUpdatePatient(patient);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
        try {
            logger.info("Fetching patient with ID {}", patientId);
            Patient patient = null;

            patient = patientService.getPatientById(patientId);
            ResponseEntity<Patient> responseEntity = new ResponseEntity<>(patient, HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {

            logger.error("Error fetching patient with ID {}: {}", patientId, e.getMessage());

            throw new PatientNotFoundException("Product not found"); // rethrow the exception to be handled by your global exception handler
        }
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long patientId) {
        logger.info("Deleting patient with id {}", patientId);

        patientService.deletePatientById(patientId);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{patientId}/medical-histories")
    public ResponseEntity<List<MedicalHistory>> getMedicalHistoriesByPatientId(@PathVariable Long patientId) {
        logger.info("Getting medical histories for patient with id {}", patientId);

        List<MedicalHistory> medicalHistories = medicalHistoryService.getMedicalHistoryListByPatientId(patientId);
        return ResponseEntity.ok(medicalHistories);
    }

    @GetMapping("/{patientId}/appointments")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        logger.info("Getting appointments list for patient with id {}", patientId);

        List<Appointment> appointments = appointmentService.getAppointmentListByPatientId(patientId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        logger.info("Getting all patients list");

        return patientService.getAllPatients();
    }
}