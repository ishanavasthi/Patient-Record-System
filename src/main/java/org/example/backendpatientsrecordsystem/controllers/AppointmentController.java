package org.example.backendpatientsrecordsystem.controllers;

import org.example.backendpatientsrecordsystem.models.Appointment;
import org.example.backendpatientsrecordsystem.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PutMapping("/")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        logger.info("Creating/Updating appointment");

        Appointment savedAppointment = appointmentService.addOrUpdateAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long appointmentId) {
        logger.info("Getting appointment with id {}", appointmentId);

        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        logger.info("Deleting appointment with id {}", appointmentId);

        appointmentService.deleteAppointmentById(appointmentId);
        return ResponseEntity.noContent().build();
    }
}
