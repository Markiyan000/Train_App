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

    public PassengerTrain(int ID, String name, Route route, List<Carriage> carriages) {
        super(ID, name, route);
        this.carriages = carriages;
        this.maxNumberPassengers = getMaxNumberPassengers();
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    public int getMaxNumberPassengers() {
        for (Carriage carriage : carriages) {
            maxNumberPassengers += carriage.getNumberSeats();
        }
        return maxNumberPassengers;
    }

    public int calculateNumberPassengers() {
        int passengers = 0;
        for (Carriage carriage : carriages) {
            passengers += carriage.getCurNumberPassengers();
        }
        return passengers;
    }

    public double[] calculateData() {
        int passengers = calculateNumberPassengers();
        double [] result = new double[2];
        result[0] = passengers;
        result[1] = passengers * new Random().nextInt(30);
        return result;
    }

    @Override
    public String infoTrain() {
        return super.infoTrain() + "Number of passengers: " + maxNumberPassengers + "\n" + "Carriages:\n" + carriages;
    }

    @Override
    public PassengerTrain create() {
        Train base = super.create();

        Creatable[] creation = {null, new Seatpost(), new Compartment(), new Lux()};

        int key;

        while (true) {
            System.out.println("Create carriage:\n1) Seatpost\n2) Compartment");
            key = scanner.nextInt();
            if (key > creation.length) break;
            carriages.add((Carriage) creation[key].create());
        }
        System.out.println();

        return new PassengerTrain(base.ID,base.name, base.route, carriages);
    }
}
