package controller.command;

import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.ConsoleView;
import view.HTMLView;
import view.View;

public class CalculationBaggage implements Command{
    Train train;

    public CalculationBaggage(){}

    public CalculationBaggage(Train train) {
        this.train = train;
    }

    public void execute() {
        View view = new ConsoleView();
        double baggage = ((PassengerTrain) train).calculateBaggage();
        view.showBaggageResult(train, baggage);
    }
}
