package controller.command;

import controller.Controller;
import model.model_instance.Creatable;
import model.model_instance.train.FreightTrain;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CreationTrain implements Command {
    List<Train> trains;
    Scanner scanner;

    public CreationTrain(List<Train> trains) {
        this.trains = trains;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Controller.logger.info("Start of creation train.");
        Creatable[] creation = {null, new PassengerTrain(), new FreightTrain()};
        System.out.println("1) Passenger\n2) Freight\n");
        Controller.logger.info("Choosing a type of train.");
        int key = scanner.nextInt();
        try {
            Controller.logger.warn("Start of process creation! A error is possible!");
            Train train = (Train) creation[key].create(new Scanner(System.in));
            Controller.logger.info("Adding train to list.");
            trains.add(train);
        } catch (InputMismatchException exception) {
            Controller.logger.error("ERROR while creation train!", exception);
        }
        Controller.logger.info("End of creation train.");
    }
}
