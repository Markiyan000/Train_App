package controller.command;

import controller.command.sort_commands.Sortable;
import controller.command.sort_commands.SortingByDistance;
import controller.command.sort_commands.SortingByPassengers;
import controller.command.sort_commands.SortingByTime;
import model.model_instance.train.Train;
import view.View;

import java.util.List;
import java.util.Scanner;

public class SortingTrains implements Command {
    List<Train> trains;
    View view;
    Scanner scanner;

    public SortingTrains(List<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        int key;
        Sortable[] sortable = {null, new SortingByDistance(), new SortingByPassengers(), new SortingByTime()};
        System.out.println("1) Sorting by distance\n2) Sorting by passengers\n3) Sorting by time of departure");
        key = scanner.nextInt();
        List<Train> sorted = sortable[key].sortTrains(trains);
        view.showTrains(sorted);
    }
}
