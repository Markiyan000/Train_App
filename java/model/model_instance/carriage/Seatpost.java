package model.model_instance.carriage;

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

    public void setConditioner(boolean conditioner) {
        isConditioner = conditioner;
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
        return super.toString() + "Seatpost{" +
                "isConditioner=" + isConditioner +
                '}';
    }
}
