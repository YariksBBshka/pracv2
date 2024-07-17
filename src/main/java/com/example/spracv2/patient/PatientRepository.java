package com.example.spracv2.patient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository <Patient, UUID> {
    Patient findByFirstnameAndLastname(String firstname, String lastname);
}

