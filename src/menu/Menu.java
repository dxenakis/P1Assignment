package menu;

import java.util.Scanner;

public class Menu {
    private  Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        boolean quit = false;
        int choice = 0;

        printFuctionalities();
        while (!quit) {
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printFuctionalities();
                    break;
                case 1:
                    //Status ασφάλισης πινακίδων
                    break;
                case 2:
                    // αυτες που πρόκειται να λείξουν
                    break;
                case 3:
                    //λιστα με τις ασφαλειες που έλειξαν
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }


    public static void printFuctionalities() {
        System.out.println("\n--Set fuctionality to perform  ");
        System.out.println("\t 1 - Vehicle Insurance Status.");
        System.out.println("\t 2 - Forecoming Expiries.");
        System.out.println("\t 3 - Expiries by plate.");
    }
}
