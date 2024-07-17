package com.example.spracv2.appointment;

import com.example.spracv2.doctor.Doctor;
import com.example.spracv2.patient.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDTO {
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Doctor fkDoctor;
    private Patient fkPatient;
    private String status;
    


    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public Doctor getFkDoctor() {
        return fkDoctor;
    }

    public Patient getFkPatient() {
        return fkPatient;
    }

    public String getStatus() {
        return status;
    }
}

