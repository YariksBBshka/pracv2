package com.example.spracv2.treatment;

import com.example.spracv2.diagnosis.Diagnosis;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }
    @GetMapping("/")
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAll();
    }

    @PostMapping("/create")
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        return treatmentService.create(treatment);
    }

    @GetMapping("/treatmentHistory")
    public List<Treatment> getHistory() {
        return null;
    }
}