package controller.command.sort_commands;

import controller.utils.TrainUtils;
import model.model_instance.train.Train;

import java.util.List;

public class SortingByDistance implements Sortable{

    @Override
    public List<Train> sortTrains(List<Train> trains) {
        List<Train> sorted = TrainUtils.sortByDistance(trains);
        return sorted;
    }
}
