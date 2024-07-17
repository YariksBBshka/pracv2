package com.example.spracv2.diagnosis;

import com.example.spracv2.appointment.Appointment;
import com.example.spracv2.common.BaseEntity;
import com.example.spracv2.treatment.Treatment;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "diagnosis")
public class Diagnosis extends BaseEntity {
    private String disease;
    private String description;
    private Appointment fkAppointment;
//    private List<Treatment> treatments;

    @Column(name = "disease", nullable = false)
    public String getDisease() {
        return disease;
    }

    @Column(name = "description", nullable = false, length = 4095)
    public String getDescription() {
        return description;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_appointment_id", nullable = false)
    public Appointment getFkAppointment() {
        return fkAppointment;
    }

    public Diagnosis(String disease, String description, Appointment fkAppointment) {
        this.disease = disease;
        this.description = description;
        this.fkAppointment = fkAppointment;
    }

    protected Diagnosis() {
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFkAppointment(Appointment fkAppointment) {
        this.fkAppointment = fkAppointment;
    }


//    @OneToMany(mappedBy = "fkDiagnosis")
//    public List<Treatment> getTreatments() {
//        return treatments;
//    }
//
//
//    public void setTreatments(List<Treatment> treatments) {
//        this.treatments = treatments;
//    }

}