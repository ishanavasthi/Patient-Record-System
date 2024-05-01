package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.models.Appointment;
import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.repositories.AppointmentRepository;
import org.example.backendpatientsrecordsystem.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }


    public List<Appointment> getAppointmentListByPatientId(Long patientId) {
        return appointmentRepository.getAppointmentListByPatientId(patientId);
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment addOrUpdateAppointment(Appointment appointment) {
        Patient patient = appointment.getPatient();
//
        if (patient.getId() == null) {

            patient = patientRepository.save(patient);
            appointment.setPatient(patient);
        }
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointmentById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}

