//Imports for the use of ArrayList collection, File, File exception, and Scanner
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Manager class that holds an ArrayList of patrons
public class LibraryManager {

    private ArrayList<Patron> patrons;

    //Constructor
    public LibraryManager() {
        patrons = new ArrayList<>();
    }
    //Methods for checking ID validity
    public Boolean isSevenDigits(int id) {
        return id >= 1000000 & id <= 9999999;
    }
    public Boolean isUniquePatronId(int id) {
        //Loop through patrons to check for ID matches
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                return false;
            }
        }
        return true;
    }
    //Method for checking fine constraints
    public Boolean isFineCorrect(Double overdueFine) {
        return overdueFine >= 0 && overdueFine <= 250;
    }

    //Method for adding a patron to the patrons list
    public void addPatron(Patron patron){
        //If ID doesn't equal 7 digits stop.
        if (!isSevenDigits(patron.getId())) {
            System.out.println("ID must be 7 digits!");
            return;
        }
        //If new ID already exists, stop.
        if (!isUniquePatronId(patron.getId())) {
            System.out.println("ID must be unique!");
            return;
        }
        //If the fine isn't correct, stop.
        if (!isFineCorrect(patron.getOverdueFine())) {
            System.out.println("Patron fine must be between 0 and 250!");
            return;
        }
        patrons.add(patron);
        System.out.println("Patron succesfully added!");

    }
    //Method for displaying the list of patrons
    public void displayAllPatrons() {
        //If the list is empty, let the user know.
        if (patrons.isEmpty()) {
            System.out.println("No patrons found!");
            return;
        }
        for (Patron patron : patrons) {
            System.out.println("----------------------------");
            System.out.println(patron);
        }
    }
    //Method for removing patrons with an ID. When we find the matching ID, remove it.
    public void removePatron(int id) {
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                patrons.remove(patron);
                System.out.println("Patron successfully removed!");
                displayAllPatrons();
                return;
            }
        }
        //Only if no ID was found.
        System.out.println("Patron does not exist!");
    }

    //Method for loading from a file
    //Handle any errors with a try/catch
    //While the current file has a next line of text, continue scanning the following line, format it,
    //and add the new patron
    public void loadFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("-");

                int id = Integer.parseInt(data[0]);   //Turn string into integer
                Double fine = Double.parseDouble(data[3]);  //Turn string into a double
                Patron patron = new Patron(id, data[1], data[2], fine);
                addPatron(patron);
            }
            fileScanner.close();
            System.out.println("File loaded successfully.");
            displayAllPatrons();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");     //Display a message for incorrect file names
        }
    }
}
