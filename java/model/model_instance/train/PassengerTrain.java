package model.model_instance.train;

import java.util.Random;

public class PassengerTrain extends Train {
    private int numberPassengers;
    private int curNumberPassengers;

    public PassengerTrain() {
    }

    public PassengerTrain(int ID, String type, String name,
                          int numberCarriages, int numberPassengers, int curNumberPassengers) {
        super(ID, type, name, numberCarriages);
        this.numberPassengers = numberPassengers;
        this.curNumberPassengers = curNumberPassengers;
    }

    public int getNumberPassengers() {
        return numberPassengers;
    }

    public void setNumberPassengers(int numberPassengers) {
        this.numberPassengers = numberPassengers;
    }

    public int getCurNumberPassengers() {
        return curNumberPassengers;
    }

    public void setCurNumberPassengers(int curNumberPassengers) {
        this.curNumberPassengers = curNumberPassengers;
    }

    public double calculateBaggage() {
        return curNumberPassengers * new Random().nextInt(20);
    }

    @Override
    public PassengerTrain create() {
        Train baseTrain = super.create();
        System.out.print("Enter number of passengers ---> ");
        int newNumberPassengers = scanner.nextInt();
        System.out.print("Enter current number of passengers ---> ");
        int newCurNumberPassengers = scanner.nextInt();
        return new PassengerTrain(baseTrain.ID, baseTrain.type, baseTrain.name, baseTrain.numberCarriages,
                newNumberPassengers, newCurNumberPassengers);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%20d %15d", numberPassengers, curNumberPassengers);
    }
}
