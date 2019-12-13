package model.model_instance.carriage;

import model.model_instance.Creatable;

import java.io.Serializable;
import java.util.Scanner;

public class Carriage implements Creatable, Serializable {
    private static final long serialVersionUID = 1;
    protected int ID;
    protected int numberSeats;
    protected int curNumberPassengers;
    protected transient Scanner scanner;

    public Carriage(){
        scanner = new Scanner(System.in);
    }

    public Carriage(int ID, int numberSeats, int curNumberPassengers) {
        this.ID = ID;
        this.numberSeats = numberSeats;
        this.curNumberPassengers = curNumberPassengers;
        scanner = new Scanner(System.in);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public int getCurNumberPassengers() {
        return curNumberPassengers;
    }

    public void setCurNumberPassengers(int curNumberPassengers) {
        this.curNumberPassengers = curNumberPassengers;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Carriage create() {
        System.out.print("\tEnter ID ---> ");
        int newID = scanner.nextInt();
        System.out.print("\tEnter number of seats ---> ");
        int newNumberSeats = scanner.nextInt();
        System.out.print("\tEnter current number of free seats ---> ");
        int newCurNumberPassengers = scanner.nextInt();
        return new Carriage(newID, newNumberSeats, newCurNumberPassengers);
    }

    public String toString() {
        return String.format("%10d %10d %10d", ID, numberSeats, curNumberPassengers);
    }
}
