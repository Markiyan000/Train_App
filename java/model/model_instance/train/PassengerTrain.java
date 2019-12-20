package model.model_instance.train;

import model.model_instance.Creatable;
import model.model_instance.carriage.Carriage;
import model.model_instance.carriage.Compartment;
import model.model_instance.carriage.Lux;
import model.model_instance.carriage.Seatpost;
import model.model_instance.data.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


/**
 * Class for describing of passenger train
 **/


public class PassengerTrain extends Train {
    /**
     * Field carriages
     */
    private List<Carriage> carriages;

    /**
     * Constructor without parameters
     */
    public PassengerTrain() {
        carriages = new ArrayList<>();
    }

    /**
     * Constructor for creating new PassengerTrain object
     *
     * @param ID        - index of train
     * @param name      - name of train
     * @param route     - route
     * @param carriages - list of carriages
     */
    public PassengerTrain(int ID, String name, Route route, List<Carriage> carriages) {
        super(ID, name, route);
        this.carriages = carriages;
    }

    /**
     * Method for getting list of carriages
     *
     * @return list of carriages
     */
    public List<Carriage> getCarriages() {
        return carriages;
    }

    /**
     * Method for setting list of carriages
     *
     * @param carriages new carriages
     */
    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    /**
     * Method for calculation a maximal number of passengers int train
     *
     * @return a maximal number of passengers
     **/
    public int getMaxNumberPassengers() {
        int maxNumberPassengers = 0;
        for (Carriage carriage : carriages) {
            maxNumberPassengers += carriage.getNumberSeats();
        }
        return maxNumberPassengers;
    }

    /**
     * Method for calculation a current number of passengers
     *
     * @return a current number of passengers
     */
    public int calculateNumberPassengers() {
        int passengers = 0;
        for (Carriage carriage : carriages) {
            passengers += carriage.getCurNumberPassengers();
        }
        return passengers;
    }

    /**
     * Method for calculation passengers and baggage in train
     *
     * @return array with two values (number of passengers and number of baggage)
     **/
    public double[] calculateData() {
        int passengers = calculateNumberPassengers();
        double[] result = new double[2];
        result[0] = passengers;
        result[1] = passengers * 15;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerTrain train = (PassengerTrain) o;
        return carriages.equals(train.carriages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carriages);
    }

    /**
     * Method for an extended description of the train
     *
     * @return return extended description of the train
     */
    @Override
    public String infoTrain() {
        return super.infoTrain() + "Number of passengers: " + getMaxNumberPassengers() + "\nCarriages:\n" + carriages;
    }

    /**
     * Method for creating new PassengerTrain object
     *
     * @return return new PassengerTrain object
     */
    @Override
    public PassengerTrain create(Scanner scanner) {
        Train base = super.create(scanner);
        Creatable[] creation = {new Seatpost(), new Compartment(), new Lux()};
        int key;
        while (true) {
            System.out.println("Create carriage:\n1) Seatpost\n2) Compartment\n3) Lux \n>3) Exit\n");
            key = scanner.nextInt();
            if (key > 3) break;
            carriages.add((Carriage) creation[--key].create(scanner));
        }
        System.out.println();
        return new PassengerTrain(base.ID, base.name, base.route, carriages);
    }
}
