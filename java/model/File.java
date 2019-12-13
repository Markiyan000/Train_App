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
            Object obj;
            boolean isExist = true;
            while (true) {
                obj = (Train) objectInputStream.readObject();
                if (obj == null) break;
                if (objectInputStream.available() != 0) break;
                trains.add((Train) obj);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return trains;
    }
}
