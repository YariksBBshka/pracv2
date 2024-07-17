package com.example.spracv2.patient;

import com.example.spracv2.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService implements BaseService<Patient, String> {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getById(String id) {
        return patientRepository.findById(UUID.fromString(id)).orElse(null);
    }
    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
    @Override
    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }
}
