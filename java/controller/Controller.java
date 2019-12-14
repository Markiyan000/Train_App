package controller;

import controller.command.Calculation;
import controller.command.Command;
import controller.command.ShowTrain;
import controller.command.ShowTrains;
import model.File;
import model.Model;
import model.model_instance.train.Train;
import view.ConsoleView;
import view.HTMLView;
import view.View;
import java.util.List;

public class Controller {
    private Model model = new File();
    private View view = new HTMLView();

    public void start() {
        List<Train> trains = model.getTrains();
        Command[] commands = {new Calculation(trains, view), new ShowTrains(trains, view), new ShowTrain(trains, view)};
        commands[1].execute();
    }
}
