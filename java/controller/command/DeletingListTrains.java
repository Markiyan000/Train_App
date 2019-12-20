package controller.command;

import controller.Controller;
import model.model_instance.train.Train;
import java.util.List;
import java.util.Scanner;

public class DeletingListTrains implements Command {
    List<Train> trains;
    Scanner scanner;

    public DeletingListTrains(List<Train> trains) {
        this.trains = trains;
        scanner = new Scanner(System.in);
    }


    @Override
    public void execute() {
        Controller.logger.info("Start of deleting list of trains.");
        trains.clear();
        Controller.logger.info("End of deleting list of trains!");
    }
}
