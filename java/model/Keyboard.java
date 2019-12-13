package model;

import model.model_instance.Creatable;
import model.model_instance.train.FreightTrain;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Keyboard implements Model {

    public List<Train> getTrains() {
        Scanner scanner = new Scanner(System.in);
        List<Train> trains = new ArrayList<Train>();
        Creatable[] creation = {null, new PassengerTrain(), new FreightTrain()};
        int key;
        while (true) {
            System.out.println("Passenger/Freight (1/2)");
            key = scanner.nextInt();
            if (key > creation.length) break;
            trains.add((Train) creation[key].create());
        }
        return trains;
    }
}
