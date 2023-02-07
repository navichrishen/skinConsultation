package GUI;

import Classes.Doctor;
import Classes.WestminsterSkinConsultationManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;


public class docTableFrame implements ActionListener {

    // Frames
    private final JFrame secondFrame = new JFrame();

    // Panels
    private final JPanel panel = new JPanel();

    // Lists
    private final String[] columns = {"Name", "Sur Name", "Date of Birth", "Mobile Number", "Medical License", "Specialisation"};

    // Tables
    private final DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    private final JTable table = new JTable(tableModel);
    private final TableCellRenderer rendererLabel = table.getTableHeader().getDefaultRenderer();

    // ImageIcons
    private final ImageIcon icon = new ImageIcon("images/home.png");

    // Buttons
    private final JButton home = new JButton(icon);
    private final JButton sort = new JButton("SORT");

    // ScrollPanes
    private final JScrollPane scrollPane = new JScrollPane(table);

    // Labels
    private final JLabel doctorTable = new JLabel("Doctor Table");
    private final JLabel labelHead = (JLabel) rendererLabel;

    // Fonts
    private final Font font = new Font(Font.MONOSPACED, Font.BOLD, 25);


    // Creating the doctor table
    public docTableFrame() {

        initialiseFrame();
        Dimensions();
        addActions();
        styles();
        initialiseTable();
        addToFrame();

    }

    // initialising the frame
    private void initialiseFrame() {

        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setTitle("Table");
        secondFrame.setLayout(null);
        secondFrame.setResizable(false);
        secondFrame.setLocationRelativeTo(null);
        secondFrame.setVisible(true);

    }

    // Setting up the dimensions and positions
    private void Dimensions() {

        secondFrame.setBounds(30, 30, 700, 350);
        home.setBounds(10, 270, 40, 40);
        sort.setBounds(60, 270, 60, 40);
        panel.setBounds(0, 100, 700, 150);
        doctorTable.setBounds(250, 30, 250, 50);
        table.setPreferredScrollableViewportSize(new Dimension(650, 100));

    }

    // initialising the table
    public void initialiseTable() {

        labelHead.setHorizontalAlignment(JLabel.CENTER);
        table.setAutoCreateRowSorter(true);
        for (int i = 0; i < WestminsterSkinConsultationManager.getDocArray().size(); i++) {
            String Name = WestminsterSkinConsultationManager.getDocArray().get(i).getName();
            String surName = WestminsterSkinConsultationManager.getDocArray().get(i).getSurName();
            String DOB = WestminsterSkinConsultationManager.getDocArray().get(i).getDateOfBirth();
            String mobileNumber = WestminsterSkinConsultationManager.getDocArray().get(i).getMobileNumber();
            String medicalLicense = WestminsterSkinConsultationManager.getDocArray().get(i).getMedicalLicenseNum();
            String specialisation = WestminsterSkinConsultationManager.getDocArray().get(i).getSpecialisation();
            Object[] data = {Name, surName, DOB, mobileNumber, medicalLicense, specialisation};
            tableModel.addRow(data);
        }

    }

    // adding the components to the frame
    private void addToFrame() {

        secondFrame.add(home);
        secondFrame.add(sort);
        secondFrame.getContentPane().add(doctorTable);
        panel.add(scrollPane);
        secondFrame.add(panel);

    }

    // frame styling
    private void styles() {

        home.setIcon(icon);
        panel.setBackground(new Color(20, 66, 114));
        secondFrame.getContentPane().setBackground(new Color(20, 66, 114));
        doctorTable.setFont(font);
        doctorTable.setForeground(new Color(70, 194, 203));

    }

    // button onclick actions
    private void addActions() {

        home.addActionListener(this);
        sort.addActionListener(this);

    }

    // method to sort table
    private void sortTable() {

        WestminsterSkinConsultationManager.getDocArray().sort(Comparator.comparing(Doctor::getName));

    }

    // onclick actions of buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        // button to go back to the home page
        if (e.getSource() == home) {

            secondFrame.dispose();
            mainFrame mainFrame = new mainFrame();

        }
        // button to sort the doctor table
        if (e.getSource() == sort) {

            sortTable();
            scrollPane.repaint();
            secondFrame.dispose();
            docTableFrame docTableFrame = new docTableFrame();

        }
    }

}
