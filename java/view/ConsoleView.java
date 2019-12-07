package view;

import model.model_instance.train.Train;

import java.util.List;

public class ConsoleView implements View {

    public void showTrains(List<Train> trains) {
        System.out.println(String.format("%-1s %10s %10s %15s %20s %15s", "ID", "Type", "Name",
                "Carriages", "Passengers", "Current"));
        System.out.println(String.format("%-1s %10s %10s %15s %20s %15s", "--", "----", "----", "---------",
                "----------", "-------"));
        for (Train train : trains) {
            System.out.println(train);
        }
    }
}
