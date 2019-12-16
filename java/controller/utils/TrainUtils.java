package controller.utils;

import model.model_instance.carriage.Carriage;
import model.model_instance.data.Route;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;

import java.util.*;

/**
 * Class for working with list of trains
 * */

public class TrainUtils {

    /**
     * Method for search train in list
     * @param trains - list of trains
     * @param name - name of the train you are looking for
     * @return found train or null
     */
    public static Train findTrain(List<Train> trains, String name) {
        for (Train train : trains) {
            String currentName = train.getName();
            if (name.equals(currentName)) return train;
        }
        return null;
    }

    /**
     * Method for sorting carriages in train by comfort level
     * @param carriages - list of carriages
     * @return sorted carriages
     */
    public static List<Carriage> sortByComfort(List<Carriage> carriages) {
        carriages.sort((o1, o2) -> {
            if (o1.levelComfort() == o2.levelComfort())
                return o1.addComfort() - o2.addComfort();
            else return o1.levelComfort() - o2.levelComfort();
        });
        return carriages;
    }

    /**
     * Method for sorting trains by distance
     * @param trains - list of trains
     * @return sorted trains
     * */
    public static List<Train> sortByDistance(List<Train> trains) {
        trains.sort((Comparator.comparingInt(o -> (int) o.getRoute().getDistance())));
        return trains;
    }

    /**
     * Method for sorting trains by number of passengers
     * @param trains - list of trains
     * @return sorted trains
     * */
    public static List<Train> sortByPassengers(List<Train> trains) {
        trains.sort((Comparator.comparingInt(o -> ((PassengerTrain) o).getMaxNumberPassengers())));
        return trains;
    }

    /**
     * Method for sorting trains by time before departure
     * @param trains - list of trains
     * @return sorted trains
     * */
    public static List<Train> sortByTime(List<Train> trains) {
        trains.sort((o1, o2) -> {
            Route first = o1.getRoute();
            Route second = o2.getRoute();
            if (first.remainingHour() == second.remainingHour())
                return first.remainingMinute() - second.remainingMinute();
            else return first.remainingHour() - second.remainingHour();
        });
        return trains;
    }

    /**
     * Method for search trains that go to the entered city
     * @param trains - list of trains
     * @param city - city
     * @return list of trains
     * */
    public static List<Train> findCity(List<Train> trains, String city) {
        List<Train> found = new ArrayList<>();
        for (Train train : trains) {
            String cityFinish = train.getRoute().getTo();
            Map<String, Integer> stops = train.getRoute().getStops();
            if (city.equals(cityFinish) || stops.containsKey(city)) {
                found.add(train);
                continue;
            }
        }
        return found;
    }

    public static Map<Carriage, Integer> findFreeSeats(Train train) {
        Map<Carriage, Integer> found = new HashMap<>();
        List<Carriage> carriages = ((PassengerTrain) train).getCarriages();
        for (Carriage carriage : carriages) {
            int seats = carriage.getNumberSeats();
            int currentSeats = carriage.getCurNumberPassengers();
            if (seats > currentSeats) found.put(carriage, seats - currentSeats);
        }
        return found;
    }

    public static List<Carriage> findByCriterion(Train train,int from,int to) {
        List<Carriage> found = new ArrayList<>();
        List<Carriage> carriages = ((PassengerTrain) train).getCarriages();
        for (Carriage carriage : carriages) {
            if ((carriage.getNumberSeats()) >= from && (carriage.getNumberSeats() <= to)) {
                found.add(carriage);
            }
        }
        return found;
    }
}
