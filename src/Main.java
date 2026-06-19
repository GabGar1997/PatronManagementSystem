import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Begin with starting the scanner, creating the manager object, and starting the userSelection method.

        Scanner input = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();
        userSelection(input, manager);

        input.close();
    }

    //Method for displaying main menu
    public static void displayMenu() {
        System.out.println("\n1. Add Patron\n2. Remove Patron\n3. Display Patrons\n4. Load from file\n5. Exit");
    }

    //Method for user selection.
    //Display the menu, ask user for an input, and save the choice.
    //Switch for the choice the user selects.
    //WHILE users selection is not 5 (Exit).
    public static void userSelection(Scanner input, LibraryManager manager) {
        int choice;

        do {
            displayMenu();
            System.out.println("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            //Each case aligns the users choice.
            switch (choice) {
                case 1:
                    System.out.println("Enter Patron ID: ");  //user is asked for inputs
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Patron name: ");
                    String name = input.nextLine();

                    System.out.println("Enter Patron address: ");
                    String address = input.nextLine();

                    System.out.println("Enter overdue fine: ");
                    double overdueFine = input.nextDouble();
                    input.nextLine();

                    Patron patron = new Patron(id, name, address, overdueFine);  //create a patron from saved variables
                    manager.addPatron(patron);
                    manager.displayAllPatrons();
                    break;
                case 2:
                    System.out.println("Enter Patron ID to remove: ");
                    id = input.nextInt();
                    input.nextLine();

                    manager.removePatron(id);
                    break;
                case 3:
                    manager.displayAllPatrons();
                    break;
                case 4:
                    System.out.println("Enter file name: ");
                    String fileName = input.nextLine();  //Save the file name
                    manager.loadFromFile(fileName);
                    break;
                case 5:
                    System.out.println("Exiting Program!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);  //Ends the program!
    }
}