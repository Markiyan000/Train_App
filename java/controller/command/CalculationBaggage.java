package controller.command;

import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;

public class CalculationBaggage implements Command{
    Train train;

    public CalculationBaggage(){}

    public CalculationBaggage(Train train) {
        this.train = train;
    }

    public void execute() {
        System.out.println(((PassengerTrain) train).calculateBaggage());
    }
}
