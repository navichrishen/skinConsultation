package Classes;

import java.io.*;
import java.util.*;

// Implements the interface for skin consultation manager class
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    // Doctor Arraylist
    private static final ArrayList<Doctor> docArray = new ArrayList<Doctor>();
    Scanner scanner = new Scanner(System.in);

    // Main menu for the functionalities
    public static void printMenu() {

        System.out.print("**************** Main Menu *****************\n" +
                " >> Press '1' to add a Doctor\n" +
                " >> Press '2' delete a Doctor\n" +
                " >> Press '3' to print the list of Doctors\n" +
                " >> Press '4' to save Doctors in the file\n" +
                " >> Press '5' to read Doctors from the file\n" +
                " >> Press '6' to Open GUI Menu\n" +
                " >> Press '7' to quit the application\n" +
                "********************************************\n");
        System.out.print("Choose your action: ");

    }

    @Override
    // Method to add Doctors to the doctor arraylist
    public void addDoctor() {

        System.out.print("Enter Doctor name: ");
        String name = scanner.next();
        name = "Dr. " + name;
        System.out.print("Enter Doctor surname: ");
        String surname = scanner.next();
        System.out.print("Enter Doctor date of birth: ");
        String DoB = scanner.next();
        System.out.print("Enter mobile number: ");
        String mobileNumber = scanner.next();
        System.out.print("Enter the medical license number: ");
        String medicalLicense = scanner.next();
        // while loop to check if the license number is already entered
        while (validateID(medicalLicense)) {
            System.out.print(" >> ID already exists, enter a new one: ");
            medicalLicense = scanner.next();
        }
        System.out.print("-----Types of Doctors-----\n" +
                "'1' for cosmeticDermatology\n" +
                "'2' for medicalDermatology\n" +
                "'3' for paediatricDermatology\n" +
                "Select a Doctor type: ");
        int type = scanner.nextInt();
        String specialisation;
        if (type == 1) {
            specialisation = "cosmeticDermatology";
            Doctor doctor = new Doctor(name, surname, DoB, mobileNumber, medicalLicense, specialisation);
            docArray.add(doctor);
            System.out.println("Doctor was successfully added ...");
            System.out.println();
        } else if (type == 2) {
            specialisation = "medicalDermatology";
            Doctor doctor = new Doctor(name, surname, DoB, mobileNumber, medicalLicense, specialisation);
            docArray.add(doctor);
            System.out.println("Doctor was successfully added ...");
            System.out.println();
        } else if (type == 3) {
            specialisation = "paediatricDermatology";
            Doctor doctor = new Doctor(name, surname, DoB, mobileNumber, medicalLicense, specialisation);
            docArray.add(doctor);
            System.out.println("Doctor was successfully added ...");
            System.out.println();
        } else {
            // If user enters invalid choice the record won't be sent to the  doctor arraylist
            System.out.println();
            System.out.println("Invalid choice, returning to the Main Menu.....");
            System.out.println();
        }

    }

    // boolean to check the validity of the medical license number
    private boolean validateID(String medNum) {

        for (Doctor d : docArray) {
            if (d.getMedicalLicenseNum().equals(medNum)) {
                return true;
            }
        }
        return false;

    }

    // method to delete doctor when medical license number is entered
    @Override
    public void deleteDoctor() {

        System.out.print("Enter the medical license number to delete a Doctor: ");
        String MedicalLicense = scanner.next();
        if (docArray.isEmpty()) {
            System.out.println(" >> No Doctors available to delete...");
        }
        while (check(MedicalLicense)) {
            System.out.print("Enter the medical license number to delete a Doctor: ");
            MedicalLicense = scanner.next();
        }

    }

    // boolean method to check the if the item id deleted
    private boolean check(String medNum) {

        for (int i = 0; i < docArray.size(); i++) {
            if (medNum.equals(docArray.get(i).getMedicalLicenseNum())) {
                docArray.remove(i);
                System.out.println(" >> Doctor " + (i + 1) + " was successfully deleted !!");
                System.out.println(" >> " + docArray.size() + " more Doctors are available..");
                return false;
            }
        }
        System.out.println(" >> No Doctors found in with " + medNum + " as license number !! ");
        return true;

    }

    @Override
    // Method to print the list of doctors
    public void printDoctor() {

        ArrayList<Doctor> sortDocArr = new ArrayList<>(docArray);
        sortDocArr.sort(Comparator.comparing(Doctor::getSurName));
        // Checking whether the doctor array is empty
        if (sortDocArr.size() == 0) {
            System.out.println("=== Doctor list is empty ===");
        }
        for (int i = 0; i < sortDocArr.size(); i++) {

            System.out.println((i + 1) + "." + " Doctor details");
            System.out.println("  >Name: " + sortDocArr.get(i).getName());
            System.out.println("  >Surname: " + sortDocArr.get(i).getSurName());
            System.out.println("  >Date of Birth: " + sortDocArr.get(i).getDateOfBirth());
            System.out.println("  >Mobile Number: " + sortDocArr.get(i).getMobileNumber());
            System.out.println("  >Medical License Number: " + sortDocArr.get(i).getMedicalLicenseNum());
            System.out.println("  >Specialised In: " + sortDocArr.get(i).getSpecialisation());
            System.out.println("--------------------------------------------");
        }

    }

    // Method to save doctors in a text file
    @Override
    public void saveDoctor() throws IOException {

        FileWriter txt = new FileWriter("Doctors.csv");
        if (docArray.isEmpty()) {
            System.out.println(" >> Nothing to save .....");
        } else {
            for (Doctor doctor : docArray) {
                txt.write(doctor.getName() + " | ");
                txt.write(doctor.getSurName() + " | ");
                txt.write(doctor.getDateOfBirth() + " | ");
                txt.write(doctor.getMobileNumber() + " | ");
                txt.write(doctor.getMedicalLicenseNum() + " | ");
                txt.write(doctor.getSpecialisation());
                txt.write(System.lineSeparator());
            }
            System.out.println("====================================================");
            System.out.println(" >> Successfully saved into 'Doctors.csv' file.... ");
            System.out.println("=====================================================");
            txt.close();
        }

    }

    // Method to read doctors and add to doctor arraylist
    public void readDoctor() throws IOException {

        try (BufferedReader buffer = new BufferedReader(new FileReader("Doctors.csv"))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "|");
                while (tokenizer.hasMoreTokens()) {
                    String name = tokenizer.nextToken().trim();
                    String surName = tokenizer.nextToken().trim();
                    String Dob = tokenizer.nextToken().trim();
                    String mobileNumber = tokenizer.nextToken().trim();
                    String medicalLicense = tokenizer.nextToken().trim();
                    String specialisation = tokenizer.nextToken().trim();
                    docArray.add(new Doctor(name, surName, Dob, mobileNumber, medicalLicense, specialisation));
                }
            }
            System.out.println("=====================================================================");
            System.out.println(" >> Doctors were successfully loaded to the program, you can proceed");
            System.out.println("=====================================================================");
        }

    }

    // Getters and Setters
    public static ArrayList<Doctor> getDocArray() {
        return docArray;
    }

}





