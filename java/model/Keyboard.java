package model;

import controller.Controller;
import model.model_instance.Creatable;
import model.model_instance.train.FreightTrain;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Keyboard implements Model {

    @Override
    public List<Train> getTrains() {
        Controller.logger.info("Start of function 'getTrains' (in Keyboard).");
        Controller.logger.info("Manually creating initial data.");
        Scanner scanner = new Scanner(System.in);
        List<Train> trains = new ArrayList<Train>();
        Creatable[] creation = {null, new PassengerTrain(), new FreightTrain()};
        int key;
        while (true) {
            Controller.logger.info("Choosing type of train.");
            System.out.println("Passenger/Freight (1/2)");
            key = scanner.nextInt();
            if (key > creation.length) break;
            try {
                Controller.logger.info("Adding train to list.");
                trains.add((Train) creation[key].create());
            } catch (InputMismatchException exception) {
                Controller.logger.error("ERROR while creating train!", exception);
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
        Controller.logger.info("End of function 'getTrains' (in Keyboard)");
        return trains;
    }
}
