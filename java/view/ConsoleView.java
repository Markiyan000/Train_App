package view;

import model.model_instance.carriage.Carriage;
import model.model_instance.train.Train;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConsoleView implements View {

    public void titleTable() {
        System.out.println(String.format("%-10s %20s %20s %20s %20s %20s %20s", "ID", "Type", "Name",
                "From", "To", "Time of start", "Time of finish"));
        System.out.println(String.format("%-10s %20s %20s %20s %20s %20s %20s", "--", "----", "----", "----",
                "--", "-------------", "--------------"));
    }

    @Override
    public void showTrains(List<Train> trains) {
        titleTable();
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    @Override
    public void showCalculationResult(Train train, double[] result) {
        System.out.println("\nTrain  -  " + train.getName());
        System.out.println("The current number of passengers ---> " + (int) result[0]);
        System.out.println("The total number of baggage ---> " + result[1]);
    }

    @Override
    public void showTrain(Train train) {
        System.out.println(train.infoTrain());
    }

    @Override
    public void showFindFreeResult(Train train, Map<Carriage, Integer> found) {
        System.out.println("\nTrain  ->  " + train.getName());
        Iterator<Map.Entry<Carriage, Integer>> entries = found.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Carriage, Integer> entry = entries.next();
            System.out.println("Carriage № " + entry.getKey().getID() + " -> free " + entry.getValue());
        }
    }
}
