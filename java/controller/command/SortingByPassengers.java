package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.train.Train;
import java.util.List;

public class SortingByPassengers implements Sortable {

    @Override
    public List<Train> sortTrains(List<Train> trains) {
        Controller.logger.info("Call function 'sortByPassengers'");
        List<Train> sorted = TrainUtils.sortByPassengers(trains);
        return sorted;
    }
}
