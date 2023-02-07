package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame implements ActionListener{

    // frames
    private JFrame mainFrame = new JFrame("Skin Consultation Centre");

    // labels
    private JLabel setLogo = new JLabel(new ImageIcon("images/finalDoc.png"));

    // buttons
    private JButton docButton = new JButton("Doctors Available");
    private JButton bookButton = new JButton("Book Consultation");

    // fonts
    private Font font = new Font(Font.MONOSPACED,  Font.BOLD, 15);


    // creating the mainframe
    public mainFrame(){

        initialise();
        Dimensions();
        styles();
        addToFrame();
        addActions();

    }

    // initialising the frame
    private void initialise(){

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

    }

    // setting up the positions and dimensions
    private void Dimensions(){

        mainFrame.setBounds(30,30, 400, 600);
        docButton.setBounds(100, 350, 200, 40);
        bookButton.setBounds(100,450,200,40);
        setLogo.setBounds(100,40, 205,255);

    }

    // adding components to the frame
    private void addToFrame(){

        mainFrame.getContentPane().add(setLogo);
        mainFrame.getContentPane().add(docButton);
        mainFrame.getContentPane().add(bookButton);

    }

    // setting up onclick actions
    private void addActions(){

        docButton.addActionListener(this);
        bookButton.addActionListener(this);

    }

    // frame styling
    private void styles(){

        mainFrame.getContentPane().setBackground(new Color(10, 38, 71));
        docButton.setFont(font);
        bookButton.setFont(font);

    }

    // button onclick actions
    @Override
    public void actionPerformed(ActionEvent e) {

        // button to access the doctor table frame
        if (e.getSource() == docButton) {

            mainFrame.dispose();
            docTableFrame docTableFrame = new docTableFrame();

        }
        // button to access the consulting page
        if (e.getSource() == bookButton) {

            mainFrame.dispose();
            consultationFrame frame3 = new consultationFrame();

        }

    }

}