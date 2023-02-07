package Classes;


// Doctor class inherited from Person parent class
public class Doctor extends Person{

    // instance variable declaration
    private String medicalLicenseNum;
    private String specialisation;

    // Doctor Constructor
    public Doctor(String name, String surName, String dateOfBirth, String mobileNumber,String medicalLicenseNum,String specialisation) {

        super(name, surName, dateOfBirth, mobileNumber);
        this.medicalLicenseNum = medicalLicenseNum;
        this.specialisation = specialisation;

    }

    // Getters and Setters
    public String getMedicalLicenseNum(){
        return medicalLicenseNum;
    }

    public void setMedicalLicenseNum(String medicalLicenseNum){
        this.medicalLicenseNum = medicalLicenseNum;
    }

    public String getSpecialisation(){
        return specialisation;
    }
    public void setSpecialisation(String specialisation){
        this.specialisation = specialisation;
    }

}
