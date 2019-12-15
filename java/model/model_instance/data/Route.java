package model.model_instance.data;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import controller.utils.StringUtils;

import java.io.Serializable;
import java.util.*;

public class Route implements Serializable {
    private static final long serialVersionUID = 1;
    private String from;
    private String to;
    private String timeStart;
    private String timeFinish;
    private double distance;
    private Map<String, Integer> stops;
    private transient Scanner scanner;

    public Route() {
        stops = new LinkedHashMap<>();
        scanner = new Scanner(System.in);
    }

    public Route(String from, String to, String timeStart, String timeFinish, double distance, Map<String, Integer> stops) {
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

    public Map<String, Integer> getStops() {
        return stops;
    }

    public void setStops(Map<String, Integer> stops) {
        this.stops = stops;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getHourStart(){
        int []time = StringUtils.splitTime(timeStart);
        return time[0];
    }

    public int getMinuteStart(){
        int []time = StringUtils.splitTime(timeStart);
        return time[1];
    }

    public int getCurHour(){
        return new Date().getHours();
    }

    public int getCurMinute(){
        return new Date().getHours();
    }

    public int remainingHour(){
        int hourStart = getHourStart();
        int curHour = getCurHour();
        if (hourStart > curHour) {
            return hourStart - curHour;
        } else return (24 + hourStart) - curHour;
    }

    public int remainingMinute() {
        return getMinuteStart() - getCurMinute();
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
        Map<String, Integer> stops = new LinkedHashMap<String, Integer>();
        do {
            System.out.print("\t\tEnter name of stop ---> ");
            String nameStop = scanner.nextLine();
            if (nameStop.equals(" ")) break;
            System.out.print("\t\tEnter duration of stop ---> ");
            int durationStop = scanner.nextInt();
            scanner.nextLine();
            stops.put(nameStop, durationStop);
        } while (true);
        return new Route(from, to, timeStart, timeFinish, distance, stops);
    }

    @Override
    public String toString() {
        return "\n\tFrom: " + from + "\n" +
                "\tTo: " + to + "\n" +
                "\tDeparture: " + timeStart + "\n" +
                "\tArrival: " + timeFinish + "\n" +
                "\tDistance: " + distance + "\n" +
                "\tStops: " + stops + "\n";
    }
}
