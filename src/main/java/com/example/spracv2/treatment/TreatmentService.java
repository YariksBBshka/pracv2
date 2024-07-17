package com.example.spracv2.treatment;

import com.example.spracv2.common.BaseService;
import com.example.spracv2.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TreatmentService implements BaseService <Treatment, String> {

    private final TreatmentRepository treatmentRepository;


    @Autowired
    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public Treatment create(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    @Override
    public Treatment getById(String id) {
        return treatmentRepository.findById(UUID.fromString(id)).orElse(null);
    }
    @Override
    public List<Treatment> getAll() {
        return treatmentRepository.findAll();
    }
    @Override
    public Treatment update(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }
    @Override
    public void delete(String id) {
        treatmentRepository.deleteById(UUID.fromString(id));
    }
}
