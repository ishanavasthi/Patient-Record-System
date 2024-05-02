package org.example.backendpatientsrecordsystem.service;

import org.example.backendpatientsrecordsystem.exceptions.MedicalHistoryNotFoundException;
import org.example.backendpatientsrecordsystem.models.Appointment;
import org.example.backendpatientsrecordsystem.models.Patient;
import org.example.backendpatientsrecordsystem.repositories.AppointmentRepository;
import org.example.backendpatientsrecordsystem.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppointmentServiceI {


    public List<Appointment> getAppointmentListByPatientId(Long patientId);


    public Appointment getAppointmentById(Long appointmentId);


    public Appointment addOrUpdateAppointment(Appointment appointment);


    public void deleteAppointmentById(Long appointmentId);
}
