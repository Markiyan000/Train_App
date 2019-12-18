package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Calculation implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public Calculation(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void execute() {
        Controller.logger.info("Start of calculation passengers and baggage.");
        System.out.println("Enter train -> ");
        Controller.logger.warn("Enter a train name! An error is possible!");
        String name = scanner.nextLine();
        Controller.logger.info("Search a train.");
        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains, name);
        if (!optionalTrain.isPresent()) {
            Controller.logger.info("Error while search!");
            System.out.println("Train isn't found!");
            return;
        }
        PassengerTrain train = (PassengerTrain) optionalTrain.get();
        Controller.logger.info("Calculation...");
        double[] result = train.calculateData();
        Controller.logger.info("Showing result of calculation to user.");
        view.showCalculationResult(train, result);
    }
}
