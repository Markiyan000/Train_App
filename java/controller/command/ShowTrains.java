package controller.command;

import model.model_instance.train.Train;
import view.ConsoleView;
import view.HTMLView;
import view.View;

import java.util.List;

public class ShowTrains implements Command {
    List<Train> trains;
    View view;

    public ShowTrains(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
    }

    public void execute() {
        view.showTrains(trains);
    }
}
