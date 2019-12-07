package model;

import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;

import java.util.ArrayList;
import java.util.List;

public class KeyboardInput implements Model {

    public List<Train> getTrains() {
        List<Train> trains = new ArrayList<Train>();
        for (int i = 0; i < 2; i++) {
            trains.add(new PassengerTrain().create());
        }
        return trains;
    }
}
