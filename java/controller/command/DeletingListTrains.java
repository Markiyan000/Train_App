package controller.command;

import controller.Controller;
import controller.command.Command;
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
        trains.clear();
    }
}
