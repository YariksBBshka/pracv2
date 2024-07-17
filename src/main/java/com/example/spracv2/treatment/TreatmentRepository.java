package com.example.spracv2.treatment;

import com.example.spracv2.diagnosis.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TreatmentRepository extends JpaRepository <Treatment, UUID> {
    List<Treatment> findByFkDiagnosis(Diagnosis diagnosis);
}
