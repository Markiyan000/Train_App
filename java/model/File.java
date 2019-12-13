package model;

import model.model_instance.train.Train;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File implements Model {
    @Override
    public List<Train> getTrains() {
        List<Train> trains = new ArrayList<Train>();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\marki\\IdeaProjects\\Train_App\\temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                if (objectInputStream.available() != 0) break;
                Train train = (Train) objectInputStream.readObject();
                trains.add(train);
            }
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (EOFException exception) {
            System.out.println(exception.getMessage());
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return trains;
    }
}
