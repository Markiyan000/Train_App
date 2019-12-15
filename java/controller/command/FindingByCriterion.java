package controller.command;

import controller.utils.TrainUtils;
import model.model_instance.carriage.Carriage;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
import java.util.Scanner;

public class FindingByCriterion implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public FindingByCriterion(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Execute on the train -> ");
        String name = scanner.nextLine();
        int from, to;

        PassengerTrain train = (PassengerTrain) TrainUtils.findTrain(trains, name);
        System.out.println("Enter interval:");
        from = scanner.nextInt();
        to = scanner.nextInt();
        List<Carriage> found = TrainUtils.findByCriterion(train, from, to);
        train.setCarriages(found);
        view.showTrain(train);
    }
}
