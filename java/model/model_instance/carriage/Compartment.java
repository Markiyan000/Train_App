package model.model_instance.carriage;

import controller.utils.StringUtils;

import java.util.Objects;
import java.util.Scanner;


/**
 * Class for describing compartment carriage
 */


public class Compartment extends Carriage {
    /**
     * Field availability of conditioner
     */
    private boolean isConditioner;

    /**
     * Field availability of press
     */
    private boolean isPress;

    /**
     * Field availability of food
     */
    private boolean isFood;

    /**
     * Constructor without parameters
     */
    public Compartment() {
    }

    /**
     * Constructor for creating an object with certain values
     *
     * @param ID                  - index of carriage
     * @param numberSeats         - number of seats
     * @param curNumberPassengers - current number of passengers
     * @param isConditioner       - availability of conditioner
     * @param isPress             - availability of press
     * @param isFood              - availability of food
     */
    public Compartment(int ID, int numberSeats, int curNumberPassengers, boolean isConditioner, boolean isPress, boolean isFood) {
        super(ID, numberSeats, curNumberPassengers);
        this.isConditioner = isConditioner;
        this.isPress = isPress;
        this.isFood = isFood;
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
     * Method of getting press value
     *
     * @return true/false (Yes/No)
     */
    public boolean isPress() {
        return isPress;
    }

    /**
     * Method of getting food value
     *
     * @return true/false (Yes/No)
     */
    public boolean isFood() {
        return isFood;
    }

    /**
     * Method for calculating additional comfort in carriage
     *
     * @return number of additional comfort
     */
    @Override
    public int addComfort() {
        int count = 0;
        boolean[] values = {isConditioner, isFood, isPress};
        for (Boolean value : values) {
            if (value) count++;
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Compartment that = (Compartment) o;
        return isConditioner == that.isConditioner &&
                isPress == that.isPress &&
                isFood == that.isFood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isConditioner, isPress, isFood);
    }

    /**
     * Method for creating new Compartment object
     *
     * @return new object
     */
    @Override
    public Compartment create(Scanner scanner) {
        Carriage base = super.create(scanner);

        System.out.print("\tEnter availability of conditioner ---> ");
        boolean isConditioner = scanner.nextBoolean();
        System.out.print("\tEnter availability of press ---> ");
        boolean isPress = scanner.nextBoolean();
        System.out.print("\tEnter availability of food --->");
        boolean isFood = scanner.nextBoolean();

        return new Compartment(base.ID, base.numberSeats, base.curNumberPassengers, isConditioner, isPress, isFood);
    }

    /**
     * Method for string description of object
     *
     * @return string description of object
     */
    @Override
    public String toString() {
        return super.toString() +
                "\tConditioner: " + StringUtils.convertBoolean(isConditioner) + "\n" +
                "\tPress: " + StringUtils.convertBoolean(isPress) + "\n" +
                "\tFood: " + StringUtils.convertBoolean(isFood) + "\n";
    }
}

