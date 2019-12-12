package controller.command;

import model.model_instance.train.Train;
import view.ConsoleView;
import view.HTMLView;
import view.View;

import java.util.List;

public class ShowTrains implements Command{
    List<Train> trains;

    public ShowTrains(List<Train> trains) {
        this.trains = trains;
    }

    public void execute() {
        View view = new HTMLView();
        view.showTrains(trains);
    }
}
