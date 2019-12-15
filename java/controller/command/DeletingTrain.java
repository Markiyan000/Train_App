package controller.command;

import controller.Controller;
import controller.command.Command;
import controller.utils.TrainUtils;
import model.model_instance.train.Train;

import java.util.List;
import java.util.Scanner;

public class DeletingTrain implements Command {
    List<Train> trains;
    Scanner scanner;

    public DeletingTrain(List<Train> trains) {
        this.trains = trains;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Enter name -> ");
        String name = scanner.nextLine();
        Train train = TrainUtils.findTrain(trains, name);
        trains.remove(train);
    }
}
