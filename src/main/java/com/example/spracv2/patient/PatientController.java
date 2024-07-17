package com.example.spracv2.patient;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientService.getAll();
    }

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.create(patient);
    }

}
