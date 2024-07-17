package com.example.spracv2.patient;

import com.example.spracv2.common.RestrictedRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends RestrictedRepository<Patient, UUID> {
}

