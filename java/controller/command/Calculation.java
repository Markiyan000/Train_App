package controller.command;

import controller.utils.TrainUtils;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
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
        System.out.println("Enter train -> ");
        String name = scanner.nextLine();

        PassengerTrain train = (PassengerTrain) TrainUtils.findTrain(trains, name);
        if (train == null) {
            System.out.println("Train isn't exist!");
            return;
        }

        double[] result = train.calculateData();
        view.showCalculationResult(train, result);
    }
}
