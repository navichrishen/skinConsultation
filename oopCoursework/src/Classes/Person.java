package Classes;

public class Person {

    // instance variable declaration
    private String name;
    private String surName;
    private String dateOfBirth;
    private String mobileNumber;

    // Person constructor
    public Person(String name, String surName, String dateOfBirth, String mobileNumber) {

        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;

    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
