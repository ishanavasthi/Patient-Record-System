package org.example.backendpatientsrecordsystem.repositories;

import org.example.backendpatientsrecordsystem.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Override
    Optional<Appointment> findById(Long aLong);

    @Override
    Appointment save(Appointment appointment);

    @Override
    void deleteById(Long aLong);

    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :patientId")
    List<Appointment> getAppointmentListByPatientId(Long patientId);
}
