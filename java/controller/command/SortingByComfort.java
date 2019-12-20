package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.carriage.Carriage;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SortingByComfort implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public SortingByComfort(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Controller.logger.info("Start of sorting carriages in train by comfort.");
        System.out.print("Execute on the train -> ");
        Controller.logger.warn("Enter a train! An error is possible!");
        String name = scanner.nextLine();
        Controller.logger.info("Call function 'searchTrain'");
        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains, name);
        if (!optionalTrain.isPresent()) {
            System.out.println("Train isn't found!");
            Controller.logger.info("An error in search a train! Not found!");
            return;
        }
        PassengerTrain train = (PassengerTrain) optionalTrain.get();
        Controller.logger.info("Call function 'sortByComfort'");
        List<Carriage> sorted = TrainUtils.sortByComfort(train.getCarriages());
        train.setCarriages(sorted);
        Controller.logger.info("Showing results to user.");
        view.showTrain(train);
        Controller.logger.info("End of sorting carriages in train by comfort.");
    }
}
