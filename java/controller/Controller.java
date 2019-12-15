package controller;

import controller.command.*;
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
        Command[] commands = {new Calculation(trains, view), new ShowTrains(trains, view),
                new ShowTrain(trains, view), new SortingTrains(trains, view), new SortingByComfort(trains, view),
                new FindingCity(trains, view), new FindingFreeSeats(trains, view), new FindingByCriterion(trains, view)};
        commands[7].execute();
    }
}