package com.example.spracv2.appointment;

import com.example.spracv2.common.RestrictedRepository;
import com.example.spracv2.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface AppointmentRepository extends RestrictedRepository<Appointment, UUID>{

    List<Appointment> findByPatientUuid(@Param("patientUuid") UUID patientUuid);

    List<Appointment> findByFkDoctorAndAppointmentDate(Doctor doctor, LocalDate date);

    List<Appointment> findByDoctorAndDate(@Param("doctor") Doctor doctor, @Param("date") LocalDate date);

}
