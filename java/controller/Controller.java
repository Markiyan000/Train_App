package controller;

import controller.command.*;
import controller.command.CreationTrain;
import controller.command.DeletingListTrains;
import controller.command.DeletingTrain;
import model.File;
import model.Model;
import model.model_instance.train.Train;
import view.HTMLView;
import view.View;
import view.menu.Menu;
import java.util.List;

import java.util.Scanner;

public class Controller {
    private Model model = new File();
    private View view = new HTMLView();

    public int entry() {
        System.out.println("Log in as:\n1) User\n2) Railway station\n");
        return new Scanner(System.in).nextInt();
    }

    public void start() {
        List<Train> trains = model.getTrains();
        Command[] commands = {new CreationTrain(trains), new DeletingTrain(trains),
                new DeletingListTrains(trains), new ShowTrains(trains, view),
                new ShowTrain(trains, view), new Calculation(trains, view),
                new FindingByCriterion(trains, view), new FindingCity(trains, view),
                new FindingFreeSeats(trains, view),
                new SortingByComfort(trains, view), new SortingTrains(trains, view)};
        int who = entry();
        int key;
        while(true) {
            key = Menu.showMenu(who);
            if(key == 0) break;
            commands[--key].execute();
        }
    }
}