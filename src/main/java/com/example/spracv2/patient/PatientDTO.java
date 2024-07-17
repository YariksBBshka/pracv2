package com.example.spracv2.patient;

import java.time.LocalDate;

public class PatientDTO {
    public  String firstname;
    public  String lastname;
    public LocalDate dateOfBirth;
    public  String address;
    public  String phoneNumber;
    public  String clientStatus;



    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getClientStatus() {
        return clientStatus;
    }
}

