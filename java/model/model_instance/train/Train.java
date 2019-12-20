package model.model_instance.train;

import model.model_instance.Creatable;
import model.model_instance.data.Route;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


/**
 * Class for describing train
 */


public class Train implements Creatable, Serializable {
    /**
     * Field serialized object identifier (for correct process of deserialization)
     */
    private static final long serialVersionUID = 1;

    /**
     * Field index of train
     */
    protected int ID;

    /**
     * Field name
     */
    protected String name;

    /**
     * Field route
     */
    protected Route route;

    /**
     * Constructor without parameters
     */
    public Train() {
        route = new Route();
    }

    /**
     * Constructor for creating new Train object
     *
     * @param ID    - index of train
     * @param name  - name of train
     * @param route - route
     */
    public Train(int ID, String name, Route route) {
        this.ID = ID;
        this.name = name;
        this.route = route;
    }

    /**
     * Method for getting ID value
     *
     * @return return value of ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Method for getting name value
     *
     * @return return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for setting field
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method for getting stops value
     *
     * @return return value of stops
     */
    public Route getRoute() {
        return route;
    }

    /**
     * Method for getting type of train in string format
     *
     * @return return type of train
     */
    public String getType() {
        if (this instanceof PassengerTrain) return "Passenger";
        else return "Freight";
    }

    /**
     * Method for an extended description of the train
     *
     * @return return extended description of the train
     */
    public String infoTrain() {
        return "ID: " + ID + "\n" +
                "Name: " + name + "\n" +
                "Route: " + route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return ID == train.ID &&
                name.equals(train.name) &&
                route.equals(train.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, route);
    }

    /**
     * Method for creating new Train object
     *
     * @return return new Train object
     */
    @Override
    public Train create(Scanner scanner) throws InputMismatchException {
        System.out.print("Enter ID ---> ");
        int newID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name ---> ");
        String newName = scanner.nextLine();
        System.out.println();
        Route route = new Route().create(scanner);
        System.out.println();
        return new Train(newID, newName, route);
    }

    /**
     * Method for string description of object
     *
     * @return string description of object
     */
    @Override
    public String toString() {
        return String.format("%-10d %20s %20s %20s %20s %20s %20s",
                ID, getType(), name, route.getFrom(), route.getTo(), route.getTimeStart(), route.getTimeFinish());
    }
}
