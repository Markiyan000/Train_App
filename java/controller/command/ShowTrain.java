package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.train.Train;
import view.View;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ShowTrain implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public ShowTrain(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Controller.logger.info("Start of showing a train.");
        System.out.print("Execute on the train -> ");
        Controller.logger.warn("Enter a train! An error is possible!");
        String name = scanner.nextLine();
        Controller.logger.info("Call function 'searchTrain'");
        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains, name);
        if (!optionalTrain.isPresent()) {
            Controller.logger.info("An error in search a train! Not found!");
            System.out.println("Train isn't found!");
            return;
        }
        Train train = optionalTrain.get();
        Controller.logger.info("Showing results to user.");
        view.showTrain(train);
        Controller.logger.info("End of showing a train.");
    }
}
