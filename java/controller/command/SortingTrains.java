package controller.command;

import controller.Controller;
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
        Controller.logger.info("Start of sorting trains.");
        int key;
        Sortable[] sortable = {null, new SortingByDistance(), new SortingByPassengers(), new SortingByTime()};
        System.out.println("1) Sorting by distance\n2) Sorting by passengers\n3) Sorting by time of departure");
        Controller.logger.warn("Choosing of sorting type! An error is possible!");
        key = scanner.nextInt();
        List<Train> sorted = sortable[key].sortTrains(trains);
        Controller.logger.info("Showing results to user.");
        view.showTrains(sorted);
        Controller.logger.info("End of sorting trains.");
    }
}
