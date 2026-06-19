// Patron class to store patrons
public class Patron {
    //Patron Attributes
    int id;
    String name;
    String address;
    double overdueFine;

    //Patron constructor
    public Patron(int id, String name, String address, double overdueFine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }
    //Getter methods
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public double getOverdueFine() {
        return overdueFine;
    }
    //Override toString to display useful information about the Patron
    //Format the overdue fine to exactly 2 decimal places
    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAddress: " +
        address + "\nOverdue Fine: " + "$" + String.format("%.2f", overdueFine);
    }
}
