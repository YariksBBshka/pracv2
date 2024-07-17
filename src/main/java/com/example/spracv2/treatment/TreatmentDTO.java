package com.example.spracv2.treatment;

import com.example.spracv2.diagnosis.Diagnosis;

public class TreatmentDTO {
    private  String medication;
    private  String instructions;
    private Diagnosis fkDiagnosis;


    public String getMedication() {
        return medication;
    }

    public String getInstructions() {
        return instructions;
    }

    public Diagnosis getFkDiagnosis() {
        return fkDiagnosis;
    }
}

