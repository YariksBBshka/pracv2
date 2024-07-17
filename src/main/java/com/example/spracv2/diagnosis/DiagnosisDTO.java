package com.example.spracv2.diagnosis;

import com.example.spracv2.appointment.Appointment;

public class DiagnosisDTO {
    private  String disease;
    private String description;
    private Appointment fkAppointment;

    public String getDisease() {
        return disease;
    }

    public String getDescription() {
        return description;
    }

    public Appointment getFkAppointment() {
        return fkAppointment;
    }
}