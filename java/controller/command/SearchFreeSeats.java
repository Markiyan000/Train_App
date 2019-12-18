package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.carriage.Carriage;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class SearchFreeSeats implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public SearchFreeSeats(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Controller.logger.info("Start of search free seats in train.");
        System.out.print("Execute on the train -> ");
        Controller.logger.warn("Enter a train name! A error is possible!");
        String name = scanner.nextLine();
        Controller.logger.info("Call function 'searchTrain'.");
        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains, name);
        if (!optionalTrain.isPresent()) {
            Controller.logger.info("Error while search! Not found!");
            System.out.println("Train isn't found!");
            Controller.logger.info("End of search free seats in train.");
            return;
        }
        PassengerTrain train = (PassengerTrain) optionalTrain.get();
        Controller.logger.info("Call function 'searchFreeSeats'.");
        Map<Carriage, Integer> found = TrainUtils.searchFreeSeats(train);
        if (found.isEmpty()) {
            Controller.logger.info("Error while search! Not found!");
            System.out.println("Not found!");
            Controller.logger.info("End of search free seats in train.");
            return;
        }
        Controller.logger.info("Showing result to user.");
        view.showFindFreeResult(train, found);
        Controller.logger.info("End of search free seats in train.");
    }
}
