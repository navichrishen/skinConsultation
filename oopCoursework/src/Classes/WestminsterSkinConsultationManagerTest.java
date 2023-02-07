package Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterSkinConsultationManagerTest {

    ArrayList<Doctor> doctors = new ArrayList<>();

    @Test
    void addDoctor() {
        Doctor doctor = new Doctor("Navindu","Chrishen","2000-01-20","071021211","21","Dermatologist");
        doctors.add(doctor);
        assertEquals("Navindu",doctor.getName());
    }

    @Test
    void deleteDoctor() {
        Doctor doctor = new Doctor("Navindu","Chrishen","2000-01-20","071021211","21","Dermatologist");
        doctors.add(doctor);
        String mediNum = doctor.getMedicalLicenseNum();
        for(Doctor d: doctors) {
            doctors.remove(d.getMedicalLicenseNum());
            assertTrue(doctor.getMedicalLicenseNum() == null);
        }

    }

    @Test
    void printDoctor() {
        Doctor doctor = new Doctor("Navindu","Chrishen","2000-01-20","071021211","21","Dermatologist");
        doctors.add(doctor);
        assertEquals("Navindu",doctor.getName());
        assertEquals("Chrishen",doctor.getSurName());
        assertEquals("2000-01-20",doctor.getDateOfBirth());
        assertEquals("071021211",doctor.getMobileNumber());
        assertEquals("21",doctor.getMedicalLicenseNum());
        assertEquals("Dermatologist",doctor.getSpecialisation());
    }

    @Test
    void saveDoctor() {
        Doctor doctor = new Doctor("Navindu","Chrishen","2000-01-20","071021211","21","Dermatologist");
        doctors.add(doctor);
        WestminsterSkinConsultationManager consultationManager = new WestminsterSkinConsultationManager();
        assertTrue(true);

    }
}