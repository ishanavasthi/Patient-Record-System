package org.example.backendpatientsrecordsystem.repositories;

import org.example.backendpatientsrecordsystem.models.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Long> {

    @Override
    Optional<MedicalHistory> findById(Long aLong);

    @Override
    MedicalHistory save(MedicalHistory medicalHistory);

    @Override
    void deleteById(Long aLong);

    @Query("SELECT m FROM MedicalHistory m WHERE m.patient.id = :patientId")
    List<MedicalHistory> findAllByPatientPatientId(Long patientId);
}