package controller.command;

import controller.utils.TrainUtils;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
import java.util.Scanner;

public class FindingCity implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public FindingCity(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }


    @Override
    public void execute() {
        String city = scanner.nextLine();
        List<Train> found = TrainUtils.findCity(trains, city);
        view.showTrains(found);
    }
}
