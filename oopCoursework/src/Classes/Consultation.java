package Classes;


import GUI.consultationFrame;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.*;
import java.util.*;


// Consultation Class
public class Consultation {

    // Keys for encryption process
    private SecretKey key;
    private final int KEY_SIZE = 128;

    // String variables declaration
    private final String cost;
    private  String date;
    private  String docName;
    private String notes;

    // Arraylists
    private static final ArrayList<Consultation> consultations = new ArrayList<>();
    private static final Map<String, List<String>> docConsul = new HashMap<>();
    private static final ArrayList<String> list = new ArrayList<String>();
    private static final ArrayList<String> dates = new ArrayList<>();
    private static final ArrayList<String> docs = new ArrayList<>();

    // Consultation constructor
    public Consultation(String cost, String notes) {

        // Get dates from hash map
        for(String d: dates){
            date = d;
        }
        // Get doctor first name from hash map
        for(String doc: docs) {
            docName = doc;
        }
        this.cost = cost;
        this.notes = notes;

    }

    // Hashmap to store doctor name and date for consultations
    public static void docConsult(String doctorName, String date)  {

        int i = 0;
        // check if map has the date already
        if (docConsul.containsKey(date)) {
            // check if the above checked date has same doctor name
            if (docConsul.get(date).contains(doctorName)) {
                // randomizing integers for the item count in doctor list
                i = new Random().nextInt(consultationFrame.getDoctorList().getItemCount());
                // iterates in doctor list and gets the random doctor name
                while (docConsul.get(date).contains(consultationFrame.getDoctorList().getItemAt(i))) {
                    i++;
                }
                // popup message if doctor is already booked
                JOptionPane.showMessageDialog(consultationFrame.getFrame3()," Doctor is already booked !! "+"\n"+" Trying to randomly assign a Doctor....");
                // assigning a random doctor
                consultationFrame.getDoctorList().setSelectedIndex(i);
                doctorName = consultationFrame.getDoctorList().getSelectedItem().toString();
                docConsul.get(date).add(doctorName);
                // slicing the hashmap key and values to two arraylists
                docs.add(doctorName);
                dates.add(date);
            }

        } else {
            // if the doctor name has not taken normally add to hashmap
            docConsul.put(date, new ArrayList<String>());
            docConsul.get(date).add(doctorName);
            docs.add(doctorName);
            dates.add(date);
            JOptionPane.showMessageDialog(consultationFrame.getFrame3()," Doctor is Available !! "+"\n"+" Proceed with patient details.");
        }

    }

    // method to encrypt notes
    public void encryptNote() throws Exception {

        String setN = null;
        for (int i = 0; i < getConsultations().size(); i++) {
            // gets the note to a string from the consultation arraylist
            setN = getConsultations().get(i).getNotes();
        }
        // initialise a key for the encryption
        KeyGenerator gen = KeyGenerator.getInstance("AES");
        // initializing the ket with a key size
        gen.init(KEY_SIZE);
        // generating the key
        key = gen.generateKey();
        // slicing the notes to a byte array
        byte[] msgInBytes = setN.getBytes();
        // creating instance of Cipher to encrypt the byte
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        // encrypting the byte array and adding it to a new byte array
        byte[] encryption = cipher.doFinal(msgInBytes);
        getEncryptedNote(encryption);

    }

    // Getters and Setters
    // getter to get the encrypted byte and returning it to notes variable
    private String getEncryptedNote(byte[] data){
        notes =Base64.getEncoder().encodeToString(data);
        return notes;
    }

    public  String getNotes() {
        return notes;
    }

    public  String getDate() {
        return date;
    }

    public  String getDocName() {
        return docName;
    }

    public static ArrayList<Consultation> getConsultations() {
        return consultations;
    }

    public static Map<String, List<String>> getDocConsul() {
        return docConsul;
    }

    public String getCost() {
        return cost;
    }

    public static ArrayList<String> getList() {
        return list;
    }

}
