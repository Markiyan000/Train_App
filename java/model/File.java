package model;

import controller.Controller;
import model.model_instance.train.Train;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File implements Model {
    @Override
    public List<Train> getTrains() {
        Controller.logger.info("Start of function 'getTrains' (in File)");
        Controller.logger.info("Reading initial data from a file.");
        List<Train> trains = new ArrayList<Train>();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\marki\\IdeaProjects\\Train_App\\source_data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                if (objectInputStream.available() != 0) break;
                Train train = (Train) objectInputStream.readObject();
                Controller.logger.info("Adding train to list.");
                trains.add(train);
            }
        } catch (ClassNotFoundException exception) {
            Controller.logger.error("ERROR while reading from a file!", exception);
            System.out.println(exception.getMessage());
        } catch (EOFException exception) {
            Controller.logger.error("ERROR while reading from a file!", exception);
            System.out.println(exception.getMessage());
        } catch (FileNotFoundException exception) {
            Controller.logger.fatal("FATAL ERROR while reading from a file! File isn't found!", exception);
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            Controller.logger.error("ERROR while reading from a file!", exception);
            System.out.println(exception.getMessage());
        }
        Controller.logger.info("End of function 'getTrains' (in File)");
        return trains;
    }
}
