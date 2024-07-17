package com.example.spracv2.diagnosis;

import com.example.spracv2.common.BaseService;
import com.example.spracv2.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiagnosisService implements BaseService <Diagnosis, String> {

    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public Diagnosis create(Diagnosis Diagnosis) {
        return diagnosisRepository.save(Diagnosis);
    }

    @Override
    public Diagnosis getById(String id) {
        return diagnosisRepository.findById(UUID.fromString(id)).orElse(null);
    }
    @Override
    public List<Diagnosis> getAll() {
        return diagnosisRepository.findAll();
    }
    @Override
    public Diagnosis update(Diagnosis Diagnosis) {
        return diagnosisRepository.save(Diagnosis);
    }
    @Override
    public void delete(String id) {
        diagnosisRepository.deleteById(UUID.fromString(id));
    }
}
