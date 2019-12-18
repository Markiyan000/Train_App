package controller.command;

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
        System.out.print("Execute on the train -> ");
        String name = scanner.nextLine();

        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains, name);
        if (!optionalTrain.isPresent()) {
            System.out.println("Train isn't found!");
            return;
        }
        PassengerTrain train = (PassengerTrain) optionalTrain.get();

        List<Carriage> sorted = TrainUtils.sortByComfort(train.getCarriages());
        train.setCarriages(sorted);
        view.showTrain(train);
    }
}
