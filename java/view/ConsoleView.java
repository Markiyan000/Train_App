package view;

import model.model_instance.train.Train;

import java.util.List;

public class ConsoleView implements View {

    public void showTrains(List<Train> trains) {
        System.out.println(String.format("%-10s %20s %20s %20s %20s %20s %20s", "ID", "Type", "Name",
                "From", "To", "Time of start", "Time of finish"));
        System.out.println(String.format("%-10s %20s %20s %20s %20s %20s %20s", "--", "----", "----", "----",
                "--", "-------------", "--------------"));
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    public void showBaggageResult(Train train, double baggage) {
        System.out.println(train.getName() + " has " + baggage + " kilograms of baggage.");
    }
}
