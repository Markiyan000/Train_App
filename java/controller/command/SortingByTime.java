package controller.command;

import controller.Controller;
import controller.utils.TrainUtils;
import model.model_instance.train.Train;
import java.util.List;

public class SortingByTime implements Sortable {
    @Override
    public List<Train> sortTrains(List<Train> trains) {
        Controller.logger.info("Call function 'sortByTime'");
        List<Train> sorted = TrainUtils.sortByTime(trains);
        return sorted;
    }
}
