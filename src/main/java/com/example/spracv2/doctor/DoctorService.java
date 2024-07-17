package com.example.spracv2.doctor;

import com.example.spracv2.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService implements BaseService<Doctor, String> {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getById(String id) {
        return doctorRepository.findById(UUID.fromString(id)).orElse(null);
    }
    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }
    @Override
    public Doctor update(Doctor Doctor) {
        return doctorRepository.save(Doctor);
    }
    @Override
    public void delete(String id) {
        doctorRepository.deleteById(UUID.fromString(id));
    }
}

