package model.model_instance.carriage;

import java.util.List;
import java.util.Scanner;

public class Carriage {
    private int ID;
    private int numberSeats;
    private int curNumberPassengers;
    private Scanner scanner;

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

    public Carriage create() {
        System.out.print("Enter ID ---> ");
        int newID = scanner.nextInt();
        System.out.println("Enter number of seats ---> ");
        int newNumberSeats = scanner.nextInt();
        System.out.print("Enter current number of free seats ---> ");
        int newCurNumberPassengers = scanner.nextInt();
        return new Carriage(newID, newNumberSeats, newCurNumberPassengers);
    }

    public String toString() {
        return String.format("%10d %10d %10d", ID, numberSeats, curNumberPassengers);
    }
}
