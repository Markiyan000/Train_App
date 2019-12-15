package model.model_instance.carriage;

import controller.utils.StringUtils;

public class Compartment extends Carriage {
   private boolean isConditioner;
   private boolean isPress;
   private boolean isFood;

    public Compartment() {
    }

    public Compartment(int ID, int numberSeats, int curNumberPassengers, boolean isConditioner, boolean isPress, boolean isFood) {
        super(ID, numberSeats, curNumberPassengers);
        this.isConditioner = isConditioner;
        this.isPress = isPress;
        this.isFood = isFood;
    }

    public boolean isConditioner() {
        return isConditioner;
    }

    public void setConditioner(boolean conditioner) {
        isConditioner = conditioner;
    }

    public boolean isPress() {
        return isPress;
    }

    public void setPress(boolean press) {
        isPress = press;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

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
    public Compartment create() {
        Carriage base = super.create();

        System.out.print("\tEnter availability of conditioner ---> ");
        boolean isConditioner = scanner.nextBoolean();
        System.out.print("\tEnter availability of press ---> ");
        boolean isPress = scanner.nextBoolean();
        System.out.print("\tEnter availability of food --->");
        boolean isFood = scanner.nextBoolean();

        return new Compartment(base.ID, base.numberSeats, base.curNumberPassengers, isConditioner, isPress, isFood);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tConditioner: " + StringUtils.changeFromBoolean(isConditioner) + "\n" +
                "\tPress: " + StringUtils.changeFromBoolean(isPress) + "\n" +
                "\tFood: " + StringUtils.changeFromBoolean(isFood) + "\n";
    }
}

