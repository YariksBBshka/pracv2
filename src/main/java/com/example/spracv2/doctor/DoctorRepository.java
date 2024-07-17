package com.example.spracv2.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository <Doctor, UUID> {
    Doctor findByFirstnameAndLastname(String firstname, String lastname);
}
