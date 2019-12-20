package model.model_instance.carriage;

import controller.utils.StringUtils;

import java.util.Objects;
import java.util.Scanner;


/**
 * Class for describing lux carriage
 */


public class Lux extends Carriage {
    /**
     * Field availability of TV
     */
    private boolean isTV;

    /**
     * Field availability of washstand
     */
    private boolean isWashStand;

    /**
     * Field availability of press
     */
    private boolean isPress;

    /**
     * Field availability of conditioner
     */
    private boolean isConditioner;

    /**
     * Field availability of food
     */
    private boolean isFood;

    /**
     * Constructor without parameters
     */
    public Lux() {
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
     * @param isTV                - availability of TV
     * @param isWashStand         - availability of washstand
     */
    public Lux(int ID, int numberSeats, int curNumberPassengers, boolean isTV, boolean isWashStand,
               boolean isPress, boolean isConditioner, boolean isFood) {
        super(ID, numberSeats, curNumberPassengers);
        this.isTV = isTV;
        this.isWashStand = isWashStand;
        this.isPress = isPress;
        this.isConditioner = isConditioner;
        this.isFood = isFood;
    }

    /**
     * Method of getting TV value
     *
     * @return true/false (Yes/No)
     */
    public boolean isTV() {
        return isTV;
    }

    /**
     * Method of getting washstand value
     *
     * @return true/false (Yes/No)
     */
    public boolean isWashStand() {
        return isWashStand;
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
     * Method of getting conditioner value
     *
     * @return true/false (Yes/No)
     */
    public boolean isConditioner() {
        return isConditioner;
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
        boolean[] values = {isConditioner, isFood, isPress, isTV, isWashStand};
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
        Lux lux = (Lux) o;
        return isTV == lux.isTV &&
                isWashStand == lux.isWashStand &&
                isPress == lux.isPress &&
                isConditioner == lux.isConditioner &&
                isFood == lux.isFood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isTV, isWashStand, isPress, isConditioner, isFood);
    }

    /**
     * Method for creating new Lux object
     *
     * @return new object
     */
    @Override
    public Lux create(Scanner scanner) {
        Carriage base = super.create(scanner);
        System.out.print("\tEnter availability of TV ---> ");
        boolean isTV = scanner.nextBoolean();
        System.out.print("\tEnter availability of washstand ---> ");
        boolean isWashStand = scanner.nextBoolean();
        System.out.print("\tEnter availability of conditioner ---> ");
        boolean isConditioner = scanner.nextBoolean();
        System.out.print("\tEnter availability of press ---> ");
        boolean isPress = scanner.nextBoolean();
        System.out.print("\tEnter availability of food --->");
        boolean isFood = scanner.nextBoolean();
        return new Lux(base.ID, base.numberSeats, base.curNumberPassengers, isTV, isWashStand, isPress,
                isConditioner, isFood);
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
                "\tFood: " + StringUtils.convertBoolean(isFood) + "\n" +
                "\tTV: " + StringUtils.convertBoolean(isTV) + "\n" +
                "\tWashstand: " + StringUtils.convertBoolean(isWashStand) + "\n";
    }
}
