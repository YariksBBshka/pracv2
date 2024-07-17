package com.example.spracv2.patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PatientRepositoryImpl implements  PatientRepository{
    @Override
    public <S extends Patient> S save(S entity) {
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public Optional<Patient> findById(UUID uuid) {
        return Optional.empty();
    }
}
