package model.model_instance.train;

import model.model_instance.carriage.Carriage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PassengerTrain extends Train {
    private int maxNumberPassengers;
    private List<Carriage> carriages;
    public PassengerTrain() {
    }

    public PassengerTrain(int ID, String type, String name,
                          int numberCarriages, int maxNumberPassengers) {
        super(ID, type, name, numberCarriages);
        this.maxNumberPassengers = maxNumberPassengers;
        carriages = new ArrayList<Carriage>();
    }

    public int getNumberPassengers() {
        return maxNumberPassengers;
    }

    public void setNumberPassengers(int maxNumberPassengers) {
        this.maxNumberPassengers = maxNumberPassengers;
    }

    public int getMaxNumberPassengers() {
        return maxNumberPassengers;
    }

    public void setMaxNumberPassengers(int maxNumberPassengers) {
        this.maxNumberPassengers = maxNumberPassengers;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    public int calculateNumberPassengers(){
        int passengers = 0;
        for(Carriage carriage : carriages) {
            passengers += carriage.getCurNumberPassengers();
        }
        return passengers;
    }

    public double calculateBaggage() {
        return calculateNumberPassengers() * new Random().nextInt(30);
    }

    @Override
    public PassengerTrain create() {
        Train baseTrain = super.create();
        System.out.print("Enter number of passengers ---> ");
        int newMaxNumberPassengers = scanner.nextInt();
        return new PassengerTrain(baseTrain.ID, baseTrain.type, baseTrain.name, baseTrain.numberCarriages,
                newMaxNumberPassengers);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%20d", maxNumberPassengers);
    }
}
