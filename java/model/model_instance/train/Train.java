package model.model_instance.train;

import java.util.Scanner;

public class Train {
    protected int ID;
    protected String type;
    protected String name;
    protected int numberCarriages;
    protected Scanner scanner;

    public Train() {
        scanner = new Scanner(System.in);
    }

    public Train(int ID, String type, String name, int numberCarriages) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.numberCarriages = numberCarriages;
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

    public int getNumberCarriages() {
        return numberCarriages;
    }

    public void setNumberCarriages(int numberCarriages) {
        this.numberCarriages = numberCarriages;
    }

    public Train create() {
        System.out.print("Enter ID ---> ");
        int newID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter type ---> ");
        String newType = scanner.nextLine();
        System.out.print("Enter name ---> ");
        String newName = scanner.nextLine();
        System.out.print("Enter number of carriages ---> ");
        int newNumberCarriages = scanner.nextInt();
        return new Train(newID, newType, newName, newNumberCarriages);
    }

    @Override
    public String toString() {
        return String.format("%-2d %10s %10s %15d", ID, type, name, numberCarriages);
    }
}
