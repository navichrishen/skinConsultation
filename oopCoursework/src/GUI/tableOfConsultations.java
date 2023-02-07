package GUI;

import Classes.Consultation;
import Classes.Patient;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

public class tableOfConsultations implements ActionListener {

    // frames
    private final JFrame frame4 = new JFrame("Consultations");

    // panels
    private final JPanel panel = new JPanel();
    private final JPanel panel2 = new JPanel();

    // lists
    private final String[] columns = {"Date of Consult", "Doctor Name", "Patient ID", "First Name", "Last Name", "Date of Birth", "Mobile Number", "Cost", "Notes(encrypted)"};

    // tables
    private final DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    private JTable table = new JTable(tableModel);

    // scroll pane
    private final JScrollPane scrollPane = new JScrollPane(table);
    private final TableCellRenderer rendererLabel = table.getTableHeader().getDefaultRenderer();

    // labels
    private final JLabel labelHead = (JLabel) rendererLabel;
    private final JLabel consultTable = new JLabel("Current Consultations");

    private final JLabel consultDetails = new JLabel();
    private final JLabel docName = new JLabel();
    private final JLabel dateCon = new JLabel();
    private final JLabel patientID = new JLabel();
    private final JLabel name = new JLabel();
    private final JLabel surName = new JLabel();
    private final JLabel dob = new JLabel();
    private final JLabel mobNum = new JLabel();
    private final JLabel cost = new JLabel();
    private final JLabel notes = new JLabel();

    // Image icons
    private final ImageIcon icon = new ImageIcon("images/home.png");
    private final ImageIcon backIcon = new ImageIcon("images/backICon.png");

    // buttons
    private final JButton home = new JButton(icon);
    private final JButton back = new JButton(backIcon);
    private final JButton back2 = new JButton(backIcon);
    private final JButton viewSelected = new JButton("View Consultations");

    // fonts
    private final Font font = new Font(Font.MONOSPACED, Font.BOLD, 17);
    private final Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 15);


    public tableOfConsultations() {

        frame();
        initialiseTable();
        dimensions();
        tableRows();
        onClick();
        Styles();
        tableRowClick();

    }

    // creating the frame
    private void frame() {

        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setLayout(null);
        panel.setLayout(new GridBagLayout());
        frame4.setResizable(false);
        frame4.setVisible(true);
        frame4.add(consultTable);
        frame4.add(home);
        frame4.add(back);
        frame4.add(viewSelected);
        panel.add(scrollPane);
        frame4.add(panel);

    }

    // initialising the table
    private void initialiseTable() {

        labelHead.setHorizontalAlignment(JLabel.CENTER);
    }

    // setting up positions and dimensions
    private void dimensions() {

        frame4.setBounds(0, 0, 1060, 400);
        home.setBounds(10, 320, 40, 40);
        viewSelected.setBounds(830, 280, 200, 40);
        consultDetails.setBounds(390, 40, 300, 30);
        dateCon.setBounds(310, 100, 200, 20);
        docName.setBounds(600, 100, 200, 30);
        name.setBounds(310, 140, 200, 30);
        surName.setBounds(600, 140, 200, 30);
        patientID.setBounds(310, 180, 200, 30);
        dob.setBounds(600, 180, 200, 30);
        mobNum.setBounds(310, 220, 200, 30);
        cost.setBounds(600, 220, 200, 30);
        notes.setBounds(340, 260, 800, 30);
        consultTable.setBounds(420, 60, 250, 25);
        back.setBounds(60, 320, 40, 40);
        back2.setBounds(60, 320, 40, 40);
        panel.setBounds(0, 40, 1060, 260);
        panel2.setBounds(0, 50, 1060, 260);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 150));

    }

    // adding back the components to the panel
    private void addToPanel2() {

        frame4.add(consultDetails);
        frame4.add(docName);
        frame4.add(dateCon);
        frame4.add(patientID);
        frame4.add(name);
        frame4.add(surName);
        frame4.add(dob);
        frame4.add(mobNum);
        frame4.add(cost);
        frame4.add(notes);
        frame4.add(back2);
    }

    // frame styles
    private void Styles() {

        frame4.getContentPane().setBackground(new Color(32, 82, 149));
        panel.setBackground(new Color(32, 82, 149));
        panel2.setBackground(Color.red);
        consultTable.setFont(font);
        consultDetails.setFont(font);
        viewSelected.setFont(font2);
        viewSelected.setEnabled(false);
        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {

            // makes the table cells uneditable
            @Override
            public boolean isCellEditable(EventObject e) {
                return false;
            }
        });

    }

    // button onclick actions
    private void onClick() {

        home.addActionListener(this);
        back.addActionListener(this);
        back2.addActionListener(this);
        viewSelected.addActionListener(this);

    }

    // adding to the table
    private void tableRows() {

        table.setAutoCreateRowSorter(true);
        for (int i = 0; i < Patient.getPatientArr().size(); i++) {
            String patientId = Patient.getPatientArr().get(i).getPatientId();
            String name = Patient.getPatientArr().get(i).getName();
            String surName = Patient.getPatientArr().get(i).getSurName();
            String DOB = Patient.getPatientArr().get(i).getDateOfBirth();
            String mobileNumber = Patient.getPatientArr().get(i).getMobileNumber();
            String date = Consultation.getConsultations().get(i).getDate();
            String docName = Consultation.getConsultations().get(i).getDocName();
            String cost = Consultation.getConsultations().get(i).getCost();
            String note = Consultation.getConsultations().get(i).getNotes();
            Object[] rowData = {date, docName, patientId, name, surName, DOB, mobileNumber, cost, note};
            tableModel.addRow(rowData);
        }

    }

    // initially keeps the labels hidden
    private void hideLabels() {

        dateCon.setText("");
        docName.setText("");
        patientID.setText("");
        name.setText("");
        surName.setText("");
        dob.setText("");
        mobNum.setText("");
        cost.setText("");
        notes.setText("");
    }

    // to get the values of the selected row
    private void tableRowClick() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 1) {
                    table = (JTable) e.getSource();
                    viewSelected.setEnabled(true);
                    int index = table.getSelectedRow();
                    TableModel model = table.getModel();
                    String date = model.getValueAt(index, 0).toString();
                    String doc = model.getValueAt(index, 1).toString();
                    String id = model.getValueAt(index, 2).toString();
                    String fName = model.getValueAt(index, 3).toString();
                    String lName = model.getValueAt(index, 4).toString();
                    String db = model.getValueAt(index, 5).toString();
                    String mob = model.getValueAt(index, 6).toString();
                    String cos = model.getValueAt(index, 7).toString();
                    String note = model.getValueAt(index, 8).toString();

                    // adding the information to the second panel
                    consultDetails.setText(" >> Consultation Details << ");
                    dateCon.setText("Date of Consult: " + date);
                    docName.setText("Doctor Name: " + doc);
                    patientID.setText("Patient ID: " + id);
                    name.setText("First Name: " + fName);
                    surName.setText("Last Name: " + lName);
                    dob.setText("Date of Birth: " + db);
                    mobNum.setText("Mobile Number: " + mob);
                    cost.setText("Cost: " + cos);
                    notes.setText("Notes(Encrypted): " + note);
                }
            }
        });
    }

    // button onclick actions
    @Override
    public void actionPerformed(ActionEvent e) {

        // home button
        if (e.getSource() == home) {

            frame4.dispose();
            mainFrame mainFrame = new mainFrame();

        }
        // back button
        if (e.getSource() == back) {

            frame4.dispose();
            frame4.repaint();
            consultationFrame consultationFrame = new consultationFrame();

        }
        // disable and hide the components which was in the panel
        if (e.getSource() == viewSelected) {

            consultTable.setVisible(false);
            panel.setVisible(false);
            back.setVisible(false);
            frame4.getContentPane().setBackground(new Color(87, 155, 177));
            viewSelected.setVisible(false);
            addToPanel2();

        }
        // enable back the components when button is selected
        if (e.getSource() == back2) {

            table.clearSelection();
            back.setVisible(true);
            viewSelected.setEnabled(false);
            viewSelected.setVisible(true);
            consultTable.setVisible(true);
            panel.setVisible(true);
            frame4.getContentPane().setBackground(new Color(32, 82, 149));
            hideLabels();

        }
    }

}
