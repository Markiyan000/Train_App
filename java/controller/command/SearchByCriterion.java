package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.carriage.Carriage;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import org.apache.log4j.Logger;
import view.View;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SearchByCriterion implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public SearchByCriterion(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Controller.logger.info("Start of search by criterion.");
        System.out.print("Execute on the train -> ");
        Controller.logger.warn("Enter a train name! A error is possible!");
        String name = scanner.nextLine();
        Controller.logger.info("Search train.");
        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains, name);
        if (!optionalTrain.isPresent()) {
            Controller.logger.info("Error while search train!");
            System.out.println("Train isn't found!");
            return;
        }
        PassengerTrain train = (PassengerTrain) optionalTrain.get();
        System.out.println("Enter interval:");
        Controller.logger.warn("Enter a interval! A error is possible!");
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        Controller.logger.info("Call function 'searchByCriterion'.");
        List<Carriage> found = TrainUtils.searchByCriterion(train, from, to);
        if (found.isEmpty()) {
            Controller.logger.info("Error while search carriages!");
            System.out.println("Carriages not found!");
        }
        train.setCarriages(found);
        Controller.logger.info("Showing results to user.");
        view.showTrain(train);
    }
}
