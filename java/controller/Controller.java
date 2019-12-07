package controller;

import controller.command.CalculationBaggage;
import controller.command.Command;
import controller.command.ShowTrains;
import model.KeyboardInput;
import model.Model;
import model.model_instance.train.Train;
import view.ConsoleView;
import view.View;

import java.util.List;

public class Controller {
    private Model model = new KeyboardInput();
    private View view = new ConsoleView();

    public void start() {
        List<Train> trains = model.getTrains();
        Command[] commands = {new CalculationBaggage(trains.get(0)), new ShowTrains(trains)};
        commands[1].execute();
    }
}
