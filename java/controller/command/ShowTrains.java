package controller.command;

import controller.Controller;
import model.model_instance.train.Train;
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
        Controller.logger.info("Start of showing list of trains.");
        view.showTrains(trains);
        Controller.logger.info("End of showing list of trains.");
    }
}
