package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
import java.util.Scanner;

public class SearchCity implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public SearchCity(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }


    @Override
    public void execute() {
        Controller.logger.info("Start of search city.");
        System.out.print("Enter city -> ");
        Controller.logger.warn("Enter a city! A error is possible!");
        String city = scanner.nextLine();
        Controller.logger.info("Call a function 'searchCity'.");
        List<Train> found = TrainUtils.searchCity(trains, city);
        if (found.isEmpty()) {
            Controller.logger.info("Error while search! Not found!");
            System.out.println("Not found!");
            Controller.logger.info("End of search city.");
            return;
        }
        Controller.logger.info("Showing results t user.");
        view.showTrains(found);
        Controller.logger.info("End of search city.");
    }
}
