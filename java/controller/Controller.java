package controller;

import controller.command.CalculationBaggage;
import controller.command.Command;
import controller.command.ShowTrains;
import model.KeyboardInput;
import model.Model;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import view.ConsoleView;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model = new KeyboardInput();
    private View view = new ConsoleView();

    public void start() {
       // List<Train> trains = model.getTrains();
        List<Train> trains = new ArrayList<Train>();
        trains.add(new PassengerTrain(1,"Passenger","668",
                11,90,79));
        trains.add(new PassengerTrain(2,"Passenger","400",
                9,107,95));
        trains.add(new PassengerTrain(3,"Passenger","45",
                10,145,80));
        Command[] commands = {new CalculationBaggage(trains.get(0)), new ShowTrains(trains)};
        commands[0].execute();
    }
}
