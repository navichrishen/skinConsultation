package Classes;

import GUI.mainFrame;
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class SkinConsultationCentre extends JFrame {
    // Main method
    public static void main(String[] args) throws IOException {

        // Consultation Manager instance
        WestminsterSkinConsultationManager consultationManager = new WestminsterSkinConsultationManager();
        Scanner scanner = new Scanner(System.in);
        // Console Menu
        WestminsterSkinConsultationManager.printMenu();
        boolean quit = false;
        try {
            while (!quit) {
                int action = scanner.nextInt();
                scanner.nextLine();
                // Switch case
                switch (action) {
                    case 1:
                        // Limit the Doctor arraylist size to 10
                        if (WestminsterSkinConsultationManager.getDocArray().size() < 10) {
                            consultationManager.addDoctor();
                            WestminsterSkinConsultationManager.printMenu();
                        } else {
                            System.out.println("Maximum Doctor Limit is 10, Cannot Add Anymore !!!");
                            WestminsterSkinConsultationManager.printMenu();
                        }
                        break;
                    case 2:
                        consultationManager.deleteDoctor();
                        WestminsterSkinConsultationManager.printMenu();
                        break;
                    case 3:
                        consultationManager.printDoctor();
                        WestminsterSkinConsultationManager.printMenu();
                        break;
                    case 4:
                        consultationManager.saveDoctor();
                        WestminsterSkinConsultationManager.printMenu();
                        break;
                    case 5:
                        consultationManager.readDoctor();
                        WestminsterSkinConsultationManager.printMenu();
                        break;
                    case 6:
                        System.out.println(" >> Opening the GUI....");
                        GUI.mainFrame mainFrame = new mainFrame();
                        WestminsterSkinConsultationManager.printMenu();
                        break;
                    case 7:
                        quit = true;
                        System.out.println("Thanks for using our service\n" +
                                "Have a nice day !!");
                }
            }

        // Catches the error if a char entered instead of integer
        }catch (java.util.InputMismatchException e){
            System.out.println(" Please enter an integer for the option menu !!!");
        }

    }

}
