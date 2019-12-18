package controller.command;

import controller.Controller;
import controller.command.Command;
import controller.utils.TrainUtils;
import model.model_instance.train.Train;

import java.util.List;
import java.util.Optional;
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
        Controller.logger.info("Start of deleting train.");
        System.out.print("Enter name -> ");
        Controller.logger.warn("Enter a train name! A error is possible!");
        String name = scanner.nextLine();
        Optional<Train> optionalTrain = TrainUtils.searchTrain(trains,name);
        if(!optionalTrain.isPresent()) {
            Controller.logger.info("Error while search train!");
            Controller.logger.info("End of deleting train!");
            System.out.println("Train isn't found!");
            return;
        }
        Train train = optionalTrain.get();
        trains.remove(train);
        Controller.logger.info("End of deleting train!");
    }
}
