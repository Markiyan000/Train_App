package controller.command;

import controller.utils.TrainUtils;
import model.model_instance.carriage.Carriage;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindingFreeSeats implements Command{
    List<Train> trains;
    View view;
    Scanner scanner;

    public FindingFreeSeats(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Execute on the train -> ");
        String name = scanner.nextLine();
        PassengerTrain train = (PassengerTrain) TrainUtils.findTrain(trains,name);
        Map<Carriage,Integer> found = TrainUtils.findFreeSeats(train);
        view.showFindFreeResult(train,found);
    }
}
