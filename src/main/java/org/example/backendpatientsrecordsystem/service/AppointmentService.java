package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.models.Appointment;
import org.example.backendpatientsrecordsystem.repositories.AppointmentRepository;

public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment addOrUpdateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointmentById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}

