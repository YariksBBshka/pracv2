package com.example.spracv2.doctor;

import com.example.spracv2.common.RestrictedRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends RestrictedRepository<Doctor, UUID> {
}
