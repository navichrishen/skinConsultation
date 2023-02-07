package GUI;

import Classes.Consultation;
import Classes.Patient;
import Classes.WestminsterSkinConsultationManager;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class consultationFrame implements ActionListener {

    // Frame
    private static JFrame frame3;

    // Lists
    private static final String[] costs = {"$15 (FirstConsult)", "$25"};
    private static final ArrayList<String> doctors = new ArrayList<>();


    // ImageIcons
    private final ImageIcon doctorI = new ImageIcon("images/doctor.png");
    private final ImageIcon patientI = new ImageIcon("images/patient.png");
    private final ImageIcon icon = new ImageIcon("images/home.png");
    private final ImageIcon clearIcon = new ImageIcon("images/icons8-remove-30.png");


    // Labels
    private final JLabel consult = new JLabel("Consult Doctor");
    private final JLabel doctor = new JLabel(doctorI);
    private final JLabel checkDoctor = new JLabel("Select a Doctor: ");
    private final JLabel patient = new JLabel(patientI);
    private final JLabel consultDate = new JLabel("Select a Date: ");
    private final JLabel patientDetails = new JLabel("Patient Details");
    private final JLabel name = new JLabel("First Name: ");
    private final JLabel surName = new JLabel("Sur Name: ");
    private final JLabel dateOfBirth = new JLabel("Date of Birth: ");
    private final JLabel mobileNumber = new JLabel("Mobile Number: ");
    private final JLabel patientID = new JLabel("Patient ID: ");
    private final JLabel cost = new JLabel("Consultation Cost: ");
    private final JLabel notes = new JLabel("Description: ");


    // ComboBoxes
    private static final JComboBox<String> doctorList = new JComboBox<String>(new DefaultComboBoxModel<String>(doctorList().toArray(new String[0])));
    private static final JComboBox<String> costL = new JComboBox<>(costs);


    // Buttons
    private final JButton docAvailable = new JButton("Availability");
    private final JButton save = new JButton("Save Patient");
    private final JButton home = new JButton(icon);
    private final JButton clear = new JButton(clearIcon);
    private final JButton view = new JButton("Consultations");


    // TxtFields
    private final JTextField nameT = new JTextField();
    private final JTextField surNameT = new JTextField();
    private final JTextField mobileNumberT = new JTextField();
    private final JTextField patientIDT = new JTextField();


    // TextArea
    private final JTextArea notesT = new JTextArea();

    // ScrollPane
    private final JScrollPane notesPane = new JScrollPane(notesT);


    // Fonts
    private final Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private final Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 15);


    // Date
    private final JDateChooser chooseDate = new JDateChooser();
    private final JDateChooser chooseBDate = new JDateChooser();
    private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    // Creating the frame
    public consultationFrame() {

        initialiseFrame();
        Dimensions();
        addActions();
        styles();
        disableFields();
        addToFrame();

    }

    // Setting up the dimensions and positions
    private void Dimensions() {

        doctor.setBounds(360, 20, 70, 70);
        consult.setBounds(305, 100, 200, 30);
        checkDoctor.setBounds(60, 140, 200, 35);
        doctorList.setBounds(160, 140, 200, 40);
        consultDate.setBounds(440, 140, 150, 35);
        chooseDate.setBounds(530, 145, 170, 25);
        docAvailable.setBounds(315, 200, 180, 40);
        patient.setBounds(370, 270, 70, 70);
        patientDetails.setBounds(315, 350, 200, 30);
        name.setBounds(60, 400, 100, 30);
        nameT.setBounds(150, 400, 200, 30);
        surName.setBounds(430, 400, 120, 30);
        surNameT.setBounds(500, 400, 200, 30);
        dateOfBirth.setBounds(60, 450, 120, 30);
        chooseBDate.setBounds(152, 455, 170, 25);
        mobileNumber.setBounds(430, 450, 120, 30);
        mobileNumberT.setBounds(540, 450, 160, 30);
        patientID.setBounds(60, 500, 120, 30);
        patientIDT.setBounds(150, 500, 150, 30);
        cost.setBounds(430, 500, 200, 30);
        costL.setBounds(550, 500, 150, 35);
        notes.setBounds(60, 540, 100, 30);
        notesPane.setBounds(150, 550, 550, 100);
        save.setBounds(200, 700, 180, 40);
        frame3.setBounds(0, 0, 780, 800);
        home.setBounds(10, 720, 40, 40);
        clear.setBounds(730, 720, 40, 40);
        view.setBounds(420, 700, 180, 40);

    }

    // initialise the frame
    private void initialiseFrame() {

        frame3 = new JFrame();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setTitle("Skin Consultation Centre");
        frame3.setLayout(null);
        frame3.setResizable(false);
        frame3.setVisible(true);

    }

    // adding components to frame
    private void addToFrame() {

        frame3.add(doctor);
        frame3.add(consult);
        frame3.add(patientDetails);
        frame3.add(checkDoctor);
        frame3.add(doctorList);
        frame3.add(consultDate);
        frame3.add(chooseDate);
        frame3.add(patient);
        frame3.add(patientDetails);
        frame3.add(docAvailable);
        frame3.add(name);
        frame3.add(nameT);
        frame3.add(surName);
        frame3.add(surNameT);
        frame3.add(dateOfBirth);
        frame3.add(chooseBDate);
        frame3.add(mobileNumber);
        frame3.add(mobileNumberT);
        frame3.add(patientID);
        frame3.add(patientIDT);
        frame3.add(cost);
        frame3.add(costL);
        frame3.add(notes);
        frame3.add(notesPane);
        frame3.add(save);
        frame3.add(home);
        frame3.add(clear);
        frame3.add(view);

    }

    // Arraylist to append doctor first names to the doctor list combo box
    public static ArrayList<String> doctorList() {

        for (int i = 0; i < WestminsterSkinConsultationManager.getDocArray().size(); i++) {
            doctors.add(WestminsterSkinConsultationManager.getDocArray().get(i).getName());
        }
        return doctors;
    }

    // On click actions
    private void addActions() {

        home.addActionListener(this);
        docAvailable.addActionListener(this);
        save.addActionListener(this);
        clear.addActionListener(this);
        view.addActionListener(this);

    }

    // initially keeps the fields disabled
    public void disableFields() {

        nameT.setEnabled(false);
        surNameT.setEnabled(false);
        mobileNumberT.setEnabled(false);
        chooseBDate.setEnabled(false);
        mobileNumberT.setEnabled(false);
        costL.setEnabled(false);
        patientIDT.setEnabled(false);
        notesT.setEnabled(false);
        save.setEnabled(false);

    }

    // enables the fields when needed
    public void enableFields() {

        nameT.setEnabled(true);
        surNameT.setEnabled(true);
        mobileNumberT.setEnabled(true);
        chooseBDate.setEnabled(true);
        mobileNumberT.setEnabled(true);
        costL.setEnabled(true);
        patientIDT.setEnabled(true);
        notesT.setEnabled(true);

    }

    // clear the fields
    public void clearFields() {

        nameT.setText("");
        surNameT.setText("");
        chooseBDate.setDate(null);
        mobileNumberT.setText("");
        patientIDT.setText("");
        notesT.setText("");

    }

    // frame styling
    public void styles() {

        frame3.getContentPane().setBackground(new Color(44, 116, 179));
        consult.setFont(font);
        patientDetails.setFont(font);
        docAvailable.setFont(font2);
        save.setFont(font2);
        clear.setFont(font2);
        view.setFont(font2);
        chooseDate.setDateFormatString("dd/MM/yyyy");
        chooseBDate.setDateFormatString("dd/MM/yyyy");

    }

    // onclick action functionalities
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == home) {

            frame3.dispose();
            save.setEnabled(true);
            mainFrame mainFrame = new mainFrame();

        }

        if (e.getSource() == docAvailable) {

            try {
                if (chooseDate.getDate() == null) {
                    JOptionPane.showMessageDialog(frame3, " Please Select a Date !! ");
                } else if (doctorList.getItemCount() == 0) {
                    JOptionPane.showMessageDialog(frame3, " Please add Doctors !! ");
                } else {
                    enableFields();
                    Consultation.docConsult(doctorList.getSelectedItem().toString(), df.format(chooseDate.getDate()));
                    save.setEnabled(true);
                    getDoctorList().setEnabled(false);
                    docAvailable.setEnabled(false);
                    chooseDate.setEnabled(false);
                }
            } catch (java.lang.NullPointerException e1) {
                JOptionPane.showMessageDialog(frame3, " Doctor and Date must be Selected !! ");
            } catch (java.lang.IllegalArgumentException exp) {
                JOptionPane.showMessageDialog(consultationFrame.frame3, "No More Doctors");
                docAvailable.setEnabled(true);
                getDoctorList().setEnabled(true);
                chooseDate.setEnabled(true);

                disableFields();
            }

        }

        if (e.getSource() == save) {
            String id = patientIDT.getText();
            while(validateID(id)) {
                patientIDT.setText("");
                break;
            }

            if ((nameT.getText().isEmpty()) || (surNameT.getText().isEmpty()) || (mobileNumberT.getText().isEmpty()) || (patientIDT.getText().isEmpty())) {

                JOptionPane.showMessageDialog(frame3, "Please fill out all fields !!");

            } else {
                try {
                    Patient patient = new Patient(nameT.getText(), surNameT.getText(), df.format(chooseBDate.getDate()), mobileNumberT.getText(), patientIDT.getText());
                    Patient.getPatientArr().add(patient);
                    Consultation consultation = new Consultation(costL.getSelectedItem().toString(), notesT.getText());
                    Consultation.getConsultations().add(consultation);
                    consultation.encryptNote();
                    JOptionPane.showMessageDialog(frame3, " Consultation was successfully placed !!");
                    clearFields();
                    disableFields();
                    getDoctorList().setEnabled(true);
                    docAvailable.setEnabled(true);
                    chooseDate.setEnabled(true);
                } catch (java.lang.NullPointerException exception) {
                    JOptionPane.showMessageDialog(frame3, " Please Select a Birthday !! ");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

            if (e.getSource() == clear) {

                clearFields();

            }
            if (e.getSource() == view) {

                frame3.dispose();
                tableOfConsultations tableOfConsultations = new tableOfConsultations();

            }

        }

    private boolean validateID(String id){
        for(Patient p : Patient.getPatientArr()){
            if(p.getPatientId().equals(id)){
                JOptionPane.showMessageDialog(frame3," Patient ID already exists !! ");
                return true;
            }
        }return false;
    }

    // Getters and setters
    public static JFrame getFrame3() {
        return frame3;
    }

    public static JComboBox<String> getDoctorList() {
        return doctorList;
    }

}
