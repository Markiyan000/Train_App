package model.model_instance.carriage;

import model.model_instance.Creatable;
import java.io.Serializable;
import java.util.Scanner;


/**
 * Class for describing passenger wagon
 */


public class Carriage implements Creatable, Serializable {
    /** Field serialVersionUID (for correct process of deserialization) */
    private static final long serialVersionUID = 1;

    /** Field ID carriage*/
    protected int ID;

    /** Field number of seats */
    protected int numberSeats;

    /**Field current number of passengers */
    protected int curNumberPassengers;

    /**Field scanner */
    protected transient Scanner scanner;

    /**
     * Constructor without parameters
     */
    public Carriage() {
        scanner = new Scanner(System.in);
    }

    /**
     * Constructor for creating an object with certain values
     * @param ID                  - carriage index
     * @param numberSeats         - number of seats
     * @param curNumberPassengers - current number of passengers
     */
    public Carriage(int ID, int numberSeats, int curNumberPassengers) {
        this.ID = ID;
        this.numberSeats = numberSeats;
        this.curNumberPassengers = curNumberPassengers;
        scanner = new Scanner(System.in);
    }

    /**
     * Method for getting field value{@link Carriage#ID}
     * @return return value of ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Method for getting field value{@link Carriage#numberSeats}
     * @return return value of number of seats
     */
    public int getNumberSeats() {
        return numberSeats;
    }

    /**
     * Method for getting field value{@link Carriage#curNumberPassengers}
     * @return return value of current number of passengers
     */
    public int getCurNumberPassengers() {
        return curNumberPassengers;
    }

    /**
     * Method for getting field value{@link Carriage#scanner}
     * @return return value of scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Method for setting field value{@link Carriage#scanner}
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Method for determining object type
     *
     * @return return string that describe type of current object
     */
    public String getType() {
        if (this instanceof Seatpost) return "Seatpost";
        if (this instanceof Compartment) return "Compartment";
        else return "Lux";
    }

    /**
     * Method for determining comfort level of current object
     */
    public int levelComfort() {
        if (this instanceof Seatpost) return 1;
        if (this instanceof Compartment) return 2;
        else return 3;
    }

    /**
     * "Abstract" method for determining additional comfort level of current object
     * @return number of additional comfort
     */
    public int addComfort() {
        return 0;
    }

    /**
     * Method for creating new object
     * @return new object
     */
    @Override
    public Carriage create() {
        System.out.print("\tEnter ID ---> ");
        int newID = scanner.nextInt();
        System.out.print("\tEnter number of seats ---> ");
        int newNumberSeats = scanner.nextInt();
        System.out.print("\tEnter current number of seats ---> ");
        int newCurNumberPassengers = scanner.nextInt();
        return new Carriage(newID, newNumberSeats, newCurNumberPassengers);
    }

    /**
     * Method for string description of object
     * @return string description of object
     */
    public String toString() {
        return "\tID: " + ID + "\n" +
                "\tNumber of seats: " + numberSeats + "\n" +
                "\tCurrent number of seats: " + curNumberPassengers + "\n";
    }
}
