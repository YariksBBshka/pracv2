package com.example.spracv2.diagnosis;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }
    @GetMapping("/")
    public List<Diagnosis> getAllDiagnosiss() {
        return diagnosisService.getAll();
    }

    @PostMapping("/create")
    public Diagnosis createDiagnosis(@RequestBody Diagnosis diagnosis) {
        return diagnosisService.create(diagnosis);
    }

    @GetMapping("/diagnosisHistory")
    public List<Diagnosis> getTopBooks() {
        return null;
    }


}
