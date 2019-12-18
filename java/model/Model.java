package model;

import model.model_instance.train.Train;

import java.util.List;

/**
 * Class for retrieving data from some source
 */

public interface Model {
    /**
     * Method for getting data about trains
     * @return list of trains
     */
    List<Train> getTrains();
}
