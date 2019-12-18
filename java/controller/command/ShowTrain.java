package controller.command;

import controller.utils.TrainUtils;
import model.model_instance.train.PassengerTrain;
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
        System.out.print("Execute on the train -> ");
        String name = scanner.nextLine();

        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains, name);
        if (!optionalTrain.isPresent()) {
            System.out.println("Train isn't found!");
            return;
        }
        Train train = optionalTrain.get();

        view.showTrain(train);
    }
}
