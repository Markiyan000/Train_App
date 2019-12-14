package model.model_instance.carriage;

import controller.utils.StringUtils;

public class Lux extends Carriage {
    private boolean isTV;
    private boolean isWashStand;
    private boolean isPress;
    private boolean isConditioner;
    private boolean isFood;

    public Lux() {
    }

    public Lux(int ID, int numberSeats, int curNumberPassengers, boolean isTV, boolean isWashStand,
               boolean isPress, boolean isConditioner, boolean isFood) {
        super(ID, numberSeats, curNumberPassengers);
        this.isTV = isTV;
        this.isWashStand = isWashStand;
        this.isPress = isPress;
        this.isConditioner = isConditioner;
        this.isFood = isFood;
    }

    public boolean isTV() {
        return isTV;
    }

    public void setTV(boolean TV) {
        isTV = TV;
    }

    public boolean isWashStand() {
        return isWashStand;
    }

    public void setWashStand(boolean washStand) {
        isWashStand = washStand;
    }

    public boolean isPress() {
        return isPress;
    }

    public void setPress(boolean press) {
        isPress = press;
    }

    public boolean isConditioner() {
        return isConditioner;
    }

    public void setConditioner(boolean conditioner) {
        isConditioner = conditioner;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    @Override
    public Lux create() {
        Carriage base = super.create();
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

    @Override
    public String toString() {
        return super.toString() +
                "\tConditioner: " + StringUtils.changeFromBoolean(isConditioner) + "\n" +
                "\tPress: " + StringUtils.changeFromBoolean(isPress) + "\n" +
                "\tFood: " + StringUtils.changeFromBoolean(isFood) + "\n" +
                "\tTV: " + StringUtils.changeFromBoolean(isTV) + "\n" +
                "\tWashstand: " + StringUtils.changeFromBoolean(isWashStand);
    }
}
