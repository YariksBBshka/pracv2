package com.example.spracv2.treatment;

import com.example.spracv2.common.RestrictedRepository;
import com.example.spracv2.diagnosis.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface TreatmentRepository extends RestrictedRepository<Treatment, UUID> {
}
