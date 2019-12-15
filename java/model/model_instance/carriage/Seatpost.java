package model.model_instance.carriage;

import controller.utils.StringUtils;

public class Seatpost extends Carriage {
    private boolean isConditioner;

    public Seatpost() {
    }

    public Seatpost(int ID, int numberSeats, int curNumberPassengers, boolean isConditioner) {
        super(ID, numberSeats, curNumberPassengers);
        this.isConditioner = isConditioner;
    }

    public boolean isConditioner() {
        return isConditioner;
    }

    @Override
    public int addComfort() {
        if(isConditioner) return 1;
        return 0;
    }

    @Override
    public Seatpost create() {
        Carriage base = super.create();
        System.out.print("\tEnter of availability of conditioner ---> ");
        isConditioner = scanner.nextBoolean();
        return new Seatpost(base.ID, base.numberSeats, base.curNumberPassengers, isConditioner);
    }

    @Override
    public String toString() {
        return super.toString() + "\tConditioner: " + StringUtils.changeFromBoolean(isConditioner) + "\n";
    }
}
