package com.example.spracv2.appointment;

import com.example.spracv2.common.BaseEntity;
import com.example.spracv2.diagnosis.Diagnosis;
import com.example.spracv2.doctor.Doctor;
import com.example.spracv2.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentStatus status;
    private Doctor fkDoctor;
    private Patient fkPatient;
    private List<Diagnosis> diagnoses;

    @Column(name = "appointment_date", nullable = false)
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
    @Column(name = "appointment_time", nullable = false)
    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_doctor_id", nullable = false)
    public Doctor getFkDoctor() {
        return fkDoctor;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_patient_id", nullable = false)
    public Patient getFkPatient() {
        return fkPatient;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 100)
    public AppointmentStatus getStatus() {
        return status;
    }

    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, AppointmentStatus status, Doctor fkDoctor, Patient fkPatient, List<Diagnosis> diagnoses) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.fkDoctor = fkDoctor;
        this.fkPatient = fkPatient;
        this.diagnoses = diagnoses;
    }

    protected Appointment(){
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setFkDoctor(Doctor fkDoctor) {
        this.fkDoctor = fkDoctor;
    }

    public void setFkPatient(Patient fkPatient) {
        this.fkPatient = fkPatient;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "fkAppointment", fetch = FetchType.LAZY)
    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }


}
