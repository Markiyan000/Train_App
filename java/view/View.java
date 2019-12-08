package view;

import model.model_instance.train.Train;
import java.util.List;

public interface View {
    void showTrains(List<Train> trains);
    void showBaggageResult(Train train, double baggage);
}
