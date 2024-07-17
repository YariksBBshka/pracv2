package com.example.spracv2.appointment;

import com.example.spracv2.common.BaseService;
import com.example.spracv2.doctor.Doctor;
import com.example.spracv2.doctor.DoctorRepository;
import com.example.spracv2.patient.Patient;
import com.example.spracv2.patient.PatientRepository;
import com.example.spracv2.patient.PatientStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService implements BaseService <Appointment, String> {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getById(String id) {
        return appointmentRepository.findById(UUID.fromString(id)).orElse(null);
    }
    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
    @Override
    public Appointment update(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    @Override
    public void delete(String id) {
        appointmentRepository.deleteById(UUID.fromString(id));
    }


    public boolean isTimeAvailable(Doctor doctor, LocalDate date, LocalTime time, Patient patient) {
        if (patient.getClientStatus() == PatientStatus.VIP && time.isBefore(LocalTime.of(19, 0))) {
            return true;
        } else if (time.isBefore(LocalTime.of(10, 0)) || time.isAfter(LocalTime.of(18, 0))) {
            return false;
        }
        List<Appointment> appointments = appointmentRepository.findByFkDoctorAndAppointmentDate(doctor, date);
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentTime().equals(time)) {
                return false;
            }
        }
        return true;
    }

    public Appointment bookAppointment(Doctor doctor, Patient patient, LocalDate date, LocalTime time) {
        if (isTimeAvailable(doctor, date, time, patient)) {
            Appointment appointment = new Appointment();
            appointment.setFkDoctor(doctor);
            appointment.setFkPatient(patient);
            appointment.setAppointmentDate(date);
            appointment.setAppointmentTime(time);
            appointment.setStatus(AppointmentStatus.BOOKED);
            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Time is not available");
        }
    }

    public Appointment completeAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.COMPLETED);
        return appointmentRepository.save(appointment);
    }

    public Appointment cancelAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.CANCELLED);
        return appointmentRepository.save(appointment);
    }





}
