package com.example.spracv2.diagnosis;

import com.example.spracv2.appointment.Appointment;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DiagnosisRepositoryImpl implements DiagnosisRepository{

    private EntityManager entityManager;
    @Override
    public <S extends Diagnosis> S save(S entity) {
        return null;
    }

    @Override
    public List<Diagnosis> findAll() {
        return null;
    }

    @Override
    public Optional<Diagnosis> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Diagnosis> findByPatientId(UUID patientId) {
        return entityManager.createQuery("SELECT d FROM Diagnosis d "
                + "JOIN d.fkAppointment a "
                + "JOIN a.fkPatient p "
                + "WHERE p.id = :patientId", Diagnosis.class).getResultList();
    }

}
