package model.model_instance.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Route implements Serializable {
    private String from;
    private String to;
    private String timeStart;
    private String timeFinish;
    private double distance;
    private HashMap<String, Double> stops;
    private transient Scanner scanner;

    public Route() {
        stops = new HashMap<String, Double>();
        scanner = new Scanner(System.in);
    }

    public Route(String from, String to, String timeStart, String timeFinish, double distance, HashMap<String, Double> stops) {
        this.from = from;
        this.to = to;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.distance = distance;
        this.stops = stops;
        scanner = new Scanner(System.in);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public HashMap<String, Double> getStops() {
        return stops;
    }

    public void setStops(HashMap<String, Double> stops) {
        this.stops = stops;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Route create() {
        System.out.print("\tEnter start of route ---> ");
        String from = scanner.nextLine();
        System.out.print("\tEnter end of route ---> ");
        String to = scanner.nextLine();
        System.out.print("\tEnter time of departure ---> ");
        String timeStart = scanner.nextLine();
        System.out.print("\tEnter time of arrival ---> ");
        String timeFinish = scanner.nextLine();
        System.out.print("\tEnter distance ---> ");
        double distance = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("\tCreate stops:");
        HashMap<String, Double> stops = new HashMap<String, Double>();
        while (true) {
            System.out.print("\t\tEnter name of stop ---> ");
            String nameStop = scanner.nextLine();
            if (nameStop.equals(" ")) break;
            System.out.print("\t\tEnter duration of stop ---> ");
            double durationStop = scanner.nextDouble();scanner.nextLine();
            stops.put(nameStop, durationStop);
        }
        return new Route(from, to, timeStart, timeFinish, distance, stops);
    }
}
