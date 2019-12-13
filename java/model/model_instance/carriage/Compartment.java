package model.model_instance.carriage;

public class Compartment extends Carriage {
    boolean isConditioner;
    boolean isPress;
    boolean isFood;

    public Compartment(){}

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

    public int levelComfort() {
        return 1;
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
        return super.toString() + "Compartment{" +
                "isConditioner=" + isConditioner +
                ", isPress=" + isPress +
                ", isFood=" + isFood +
                '}';
    }
}

