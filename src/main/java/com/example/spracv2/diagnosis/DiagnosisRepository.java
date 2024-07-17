package com.example.spracv2.diagnosis;

import com.example.spracv2.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, UUID> {
    @Query("SELECT d FROM Diagnosis d JOIN d.fkAppointment a JOIN a.fkPatient p WHERE p.id = :patientId")
    List<Diagnosis> findDiagnosisHistoryByPatientId(@Param("patientId") Long patientId);

    List<Diagnosis> findByFkAppointment(Appointment appointment);
}
