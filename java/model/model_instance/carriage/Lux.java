package model.model_instance.carriage;

public class Lux extends Carriage {
    private boolean isTV;
    private boolean isWashStand;
    private boolean isPress;
    private boolean isConditioner;
    private boolean isFood;

    public Lux(){}

    public Lux(int ID, int numberSeats, int curNumberPassengers, boolean isTV, boolean isWashStand,
               boolean isPress, boolean isConditioner, boolean isFood) {
        super(ID, numberSeats, curNumberPassengers);
        this.isTV = isTV;
        this.isWashStand = isWashStand;
        this.isPress = isPress;
        this.isConditioner = isConditioner;
        this.isFood = isFood;
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
}
