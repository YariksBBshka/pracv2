package com.example.spracv2.appointment;

import com.example.spracv2.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository <Appointment, UUID> {
    @Query("SELECT a FROM Appointment a WHERE a.fkDoctor = :doctor AND a.appointmentDate = :date")
    List<Appointment> findByDoctorAndDate(@Param("doctor") Doctor doctor, @Param("date") LocalDate date);

    List<Appointment> findByFkDoctorAndAppointmentDate(Doctor doctor, LocalDate date);
}