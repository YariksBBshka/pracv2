package com.example.spracv2.diagnosis;

import com.example.spracv2.appointment.Appointment;
import com.example.spracv2.common.RestrictedRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DiagnosisRepository extends RestrictedRepository<Diagnosis, UUID> {
    List<Diagnosis> findByPatientId(@Param("patientId") UUID patientId);

}
