package model.model_instance.carriage;

import controller.utils.StringUtils;

import java.util.Objects;
import java.util.Scanner;

/**
 * Class for describing seatpost carriage
 */

public class Seatpost extends Carriage {
    /**
     * Field availability of conditioner
     */
    private boolean isConditioner;

    /**
     * Constructor without parameters
     */
    public Seatpost() {
    }

    /**
     * Constructor for creating an object with certain values
     *
     * @param ID                  - index of carriage
     * @param numberSeats         - number of seats
     * @param curNumberPassengers - current number of passengers
     * @param isConditioner       - availability of conditioner
     */
    public Seatpost(int ID, int numberSeats, int curNumberPassengers, boolean isConditioner) {
        super(ID, numberSeats, curNumberPassengers);
        this.isConditioner = isConditioner;
    }

    /**
     * Method of getting conditioner value
     *
     * @return true/false (Yes/No)
     */
    public boolean isConditioner() {
        return isConditioner;
    }

    /**
     * Method for calculating additional comfort in carriage
     *
     * @return number of additional comfort
     */
    @Override
    public int addComfort() {
        if (isConditioner) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Seatpost seatpost = (Seatpost) o;
        return isConditioner == seatpost.isConditioner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isConditioner);
    }

    /**
     * Method for creating new Seatpost object
     *
     * @return new object
     */
    @Override
    public Seatpost create(Scanner scanner) {
        Carriage base = super.create(scanner);
        System.out.print("\tEnter of availability of conditioner ---> ");
        isConditioner = scanner.nextBoolean();
        return new Seatpost(base.ID, base.numberSeats, base.curNumberPassengers, isConditioner);
    }

    /**
     * Method for string description of object
     *
     * @return string description of object
     */
    @Override
    public String toString() {
        return super.toString() + "\tConditioner: " + StringUtils.convertBoolean(isConditioner) + "\n";
    }
}
