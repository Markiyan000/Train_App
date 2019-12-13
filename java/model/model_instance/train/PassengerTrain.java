package model.model_instance.train;

import model.model_instance.Creatable;
import model.model_instance.carriage.Carriage;
import model.model_instance.carriage.Compartment;
import model.model_instance.carriage.Lux;
import model.model_instance.carriage.Seatpost;
import model.model_instance.data.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PassengerTrain extends Train {
    private int maxNumberPassengers;
    private List<Carriage> carriages;

    public PassengerTrain() {
        carriages = new ArrayList<Carriage>();
    }

    public PassengerTrain(int ID, String type, String name, Route route, int maxNumberPassengers, List<Carriage> carriages) {
        super(ID, type, name, route);
        this.maxNumberPassengers = maxNumberPassengers;
        this.carriages = carriages;
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

    public int calculateNumberPassengers() {
        int passengers = 0;
        for (Carriage carriage : carriages) {
            passengers += carriage.getCurNumberPassengers();
        }
        return passengers;
    }

    public double calculateBaggage() {
        return calculateNumberPassengers() * new Random().nextInt(30);
    }

    @Override
    public PassengerTrain create() {
        Train base = super.create();

        System.out.print("Enter number of passengers ---> ");
        int newMaxNumberPassengers = scanner.nextInt();
        System.out.println();

        Creatable[] creation = {null, new Seatpost(), new Compartment(), new Lux()};

        int key;

        while (true) {
            System.out.println("Create carriage:\n1) Seatpost\n2) Compartment");
            key = scanner.nextInt();
            if (key > creation.length) break;
            carriages.add((Carriage) creation[key].create());
        }
        System.out.println();

        return new PassengerTrain(base.ID, base.type, base.name, base.route, newMaxNumberPassengers, carriages);
    }
}
