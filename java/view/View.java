package view;

import model.model_instance.train.Train;
import java.util.List;

public interface View {
    void showTrains(List<Train> trains);
    void showCalculationResult(Train train, double []result);
    void showTrain(Train train);
}
