package com.example.spracv2.appointment;

import com.example.spracv2.diagnosis.Diagnosis;
import com.example.spracv2.doctor.Doctor;
import com.example.spracv2.doctor.DoctorService;
import com.example.spracv2.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    private PatientService patientService;

    private DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping("/")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAll();
    }

    @PostMapping("/booking")
    public void bookAppointment(@RequestBody AppointmentBookingDTO appointmentBookingDTO) {
        Appointment appointment = new Appointment()
                .setFkDoctor(doctorService.getById(appointmentBookingDTO.getDoctorId()))
                .setFkPatient(patientService.getById(appointmentBookingDTO.getPatientId()))
                .setAppointmentDate(appointmentBookingDTO.getLocalDate())
                .setAppointmentTime(appointmentBookingDTO.getLocalTime());
        appointmentService.create(appointment);


    }

    @PostMapping("/complete/{id}")
    public void completeAppointment(@PathVariable UUID id) {
        appointmentService.completeAppointment(appointmentService.getById(String.valueOf(id)));
    }

    @PostMapping("/cancel/{id}")
    public void cancelAppointment(@PathVariable UUID id) {
        appointmentService.cancelAppointment(appointmentService.getById(String.valueOf(id)));
    }

    @GetMapping("/appointmentHistory/{id}")
    public List<Appointment> getHistory(@PathVariable UUID id) {
        return appointmentService.getAHistory(id);
    }

}

