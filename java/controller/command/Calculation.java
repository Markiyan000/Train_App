package controller.command;

import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.View;

import java.util.List;

public class Calculation implements Command {
    List<Train> trains;
    View view;

    public Calculation() {
    }

    public Calculation(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
    }

    public void execute() {
        PassengerTrain train = (PassengerTrain) trains.get(0);
        double []result = train.calculateData();
        view.showCalculationResult(train, result);
    }
}
