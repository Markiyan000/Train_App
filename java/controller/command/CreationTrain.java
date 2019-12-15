package controller.command;

import controller.Controller;
import controller.command.Command;
import model.model_instance.Creatable;
import model.model_instance.train.FreightTrain;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CreationTrain implements Command {
    List<Train> trains;
    Scanner scanner;

    public CreationTrain(List<Train> trains) {
        this.trains = trains;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Creatable[] creation = {null, new PassengerTrain(), new FreightTrain()};
        System.out.println("1) Passenger\n2) Freight\n");
        int key = scanner.nextInt();
        try {
            Train train = (Train) creation[key].create();
            trains.add(train);
        }catch(InputMismatchException exception){
            System.out.println(exception.getMessage());

        }
    }
}
