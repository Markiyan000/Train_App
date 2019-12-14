package controller.utils;

import model.model_instance.train.Train;

import java.util.List;

public class TrainUtils {
    public static Train findTrain(List<Train> trains, String name) {
        for (Train train : trains) {
            String currentName = train.getName();
            if (name.equals(currentName)) return train;
        }
        return null;
    }
}
