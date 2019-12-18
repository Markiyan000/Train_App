package controller;

import controller.command.*;
import controller.command.CreationTrain;
import controller.command.DeletingListTrains;
import controller.command.DeletingTrain;
import controller.utils.EmailUtils;
import model.File;
import model.Model;
import model.model_instance.train.Train;
import org.apache.log4j.Logger;
import view.HTMLView;
import view.View;
import view.menu.Menu;
import java.util.List;

import java.util.Scanner;

/**
 * Class for managing the program
 * */

public class Controller {
    public static final Logger logger = Logger.getLogger("LOGGER");
    /** Field model (the source of the data that will be processed)*/
    private Model model = new File();

    /** Field view (showing results to the user)*/
    private View view = new HTMLView();

    /**
     * Method for entrance in the program
     * @return 1/2 (User/Railway station)
     */
    public int entrance() {
        System.out.println("Log in as:\n1) User\n2) Railway station\n");
        return new Scanner(System.in).nextInt();
    }

    /**
     * Method for starting the program
     */
    public void start() {
        logger.info("Start of the program!");
        List<Train> trains = model.getTrains();
        Command[] commands = {new CreationTrain(trains), new DeletingTrain(trains),
                new DeletingListTrains(trains), new ShowTrains(trains, view),
                new ShowTrain(trains, view), new Calculation(trains, view),
                new SearchByCriterion(trains, view), new SearchCity(trains, view),
                new SearchFreeSeats(trains, view),
                new SortingByComfort(trains, view), new SortingTrains(trains, view)};
        int who = entrance();
        int key;
        while(true) {
            key = Menu.showMenu(who);
            if(key == 0) break;
            commands[--key].execute();
        }
    }
}