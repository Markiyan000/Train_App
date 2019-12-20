package controller.command;

import model.model_instance.train.Train;
import java.util.List;

public interface Sortable {
    public List<Train> sortTrains(List<Train> trains);
}
