package model.model_instance.train;

import model.model_instance.Creatable;
import model.model_instance.data.Route;

import java.io.Serializable;
import java.util.Scanner;

public class Train implements Creatable, Serializable {
    protected int ID;
    protected String type;
    protected String name;
    protected Route route;
    protected transient Scanner scanner;

    public Train() {
        scanner = new Scanner(System.in);
        route = new Route();
    }

    public Train(int ID, String type, String name,Route route) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.route = route;
        scanner = new Scanner(System.in);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Route getRoute() { return route; }

    public void setRoute(Route route) { this.route = route; }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Train create() {
        System.out.print("Enter ID ---> ");
        int newID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter type ---> ");
        String newType = scanner.nextLine();
        System.out.print("Enter name ---> ");
        String newName = scanner.nextLine();
        System.out.println();
        Route route = new Route().create();
        System.out.println();
        return new Train(newID, newType, newName, route);
    }

    @Override
    public String toString() {
        return String.format("%-10d %20s %20s %20s %20s %20s %20s",
                ID, type, name, route.getFrom(), route.getTo(), route.getTimeStart(), route.getTimeFinish());
    }
}
