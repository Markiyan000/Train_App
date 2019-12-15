package controller.command;

import controller.utils.TrainUtils;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
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
        String name = scanner.nextLine();
        PassengerTrain train = (PassengerTrain) TrainUtils.findTrain(trains, name);
        if (train == null) {
            System.out.println("Train isn't exist!");
            return;
        }
        view.showTrain(train);
    }
}
