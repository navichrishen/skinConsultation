package Classes;

import java.util.ArrayList;

// Patient class inherited from Person parent class
public class Patient extends Person {

    // instance variable declaration
    private String patientId;
    private static ArrayList<Patient> patientArr = new ArrayList<>();

    // Constructor for Patient
    public Patient(String name, String surName, String dateOfBirth, String mobileNumber, String patientId) {

        super(name, surName, dateOfBirth, mobileNumber);
        this.patientId = patientId;

    }

    // Getters and Setters
    public static ArrayList<Patient> getPatientArr() {
        return patientArr;
    }


    public String getPatientId() {
        return patientId;
    }

}
