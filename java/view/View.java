package view;

import model.model_instance.carriage.Carriage;
import model.model_instance.train.Train;
import java.util.List;
import java.util.Map;

public interface View {
    void showTrains(List<Train> trains);
    void showCalculationResult(Train train, double[] result);
    void showTrain(Train train);
    void showFindFreeResult(Train train, Map<Carriage, Integer> found);
}
