package com.example.spracv2.appointment;

import com.example.spracv2.doctor.Doctor;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AppointmentRepositoryImpl implements AppointmentRepository {
    private EntityManager entitymanager;
    @Override
    public <S extends Appointment> S save(S entity) {
        entitymanager.persist(entity);
        return entity;
    }

    @Override
    public List<Appointment> findAll() {
        return entitymanager.createQuery("FROM Appointment", Appointment.class).getResultList();
    }

    @Override
    public Optional<Appointment> findById(UUID uuid) {
        Appointment appointment = entitymanager.find(Appointment.class, uuid);
        return Optional.ofNullable(appointment);
    }

    @Override
    public List<Appointment> findByPatientUuid(UUID patientUuid) {
        return entitymanager.createQuery("SELECT a FROM Appointment a WHERE a.fkPatient.id = :patientUuid", Appointment.class).getResultList();
    }

    @Override
    public List<Appointment> findByFkDoctorAndAppointmentDate(Doctor doctor, LocalDate date) {
        return null;
    }

    @Override
    public List<Appointment> findByDoctorAndDate(Doctor doctor, LocalDate date) {
        return entitymanager.createQuery("SELECT a FROM Appointment a WHERE a.fkDoctor = :doctor AND a.appointmentDate = :date", Appointment.class).getResultList();
    }
}
