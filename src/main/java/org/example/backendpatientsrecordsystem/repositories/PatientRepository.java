package org.example.backendpatientsrecordsystem.repositories;

import org.example.backendpatientsrecordsystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Override
    Optional<Patient> findById(Long Id);

    @Override
    Patient save(Patient patient);

    @Override
    void deleteById(Long aLong);

    @Override
    List<Patient> findAll();
}
