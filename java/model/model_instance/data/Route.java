package model.model_instance.data;

import controller.utils.StringUtils;
import java.io.Serializable;
import java.util.*;


/**
 * Class for describing the route of the train
 */


public class Route implements Serializable {
    /**Field serialVersionUID (for correct process of deserialization)*/
    private static final long serialVersionUID = 1;

    /** Field a point of departure*/
    private String from;

    /**Field a point of arrival*/
    private String to;

    /**Field time of departure*/
    private String timeStart;

    /**Field time of arrival*/
    private String timeFinish;

    /**Field distance*/
    private double distance;

    /**Field stops*/
    private Map<String, Integer> stops;

    /**Field scanner*/
    private transient Scanner scanner;

    /**
     * Constructor without parameters
     * */
    public Route() {
        stops = new LinkedHashMap<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Constructor for creating new object with certain values
     * @param from - a point of departure
     * @param to - a point of arrival
     * @param timeStart - time of departure
     * @param timeFinish - time of arrival
     * @param distance - distance between cities
     * @param stops - stops during cities
     */
    public Route(String from, String to, String timeStart, String timeFinish, double distance, Map<String, Integer> stops) {
        this.from = from;
        this.to = to;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.distance = distance;
        this.stops = stops;
        scanner = new Scanner(System.in);
    }

    /**
     * Method for getting a point of departure value
     * @return a point of departure
     */
    public String getFrom() {
        return from;
    }

    /**
     * Method for getting a point of arrival value
     * @return a point of arrival
     */
    public String getTo() {
        return to;
    }

    /**
     * Method for getting time of departure value
     * @return time of departure
     */
    public String getTimeStart() {
        return timeStart;
    }

    /**
     * Method for getting time of arrival value
     * @return time of arrival
     */
    public String getTimeFinish() {
        return timeFinish;
    }

    /**
     * Method for getting a distance value
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Method for getting stops
     * @return stops
     */
    public Map<String, Integer> getStops() {
        return stops;
    }

    /**
     * Method for getting scanner
     * @return scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Method for setting scanner value
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Method for getting an hour of departure (in integer value)
     * @return integer value of an hour of departure
     */
    public int getHourStart(){
        int []time = StringUtils.splitTime(timeStart);
        return time[0];
    }

    /**
     * Method for getting a minute of departure (in integer value)
     * @return integer value of a minute of departure
     */
    public int getMinuteStart(){
        int []time = StringUtils.splitTime(timeStart);
        return time[1];
    }

    /**
     * Static method of getting current hour
     * @return current hour
     */
    public static int getCurHour(){
        return new Date().getHours();
    }

    /**
     * Static method of getting current minute
     * @return current minute
     */
    public static int getCurMinute(){
        return new Date().getMinutes();
    }

    /**
     * Method for calculation remaining time between hour of departure and current hour
     * @return a point of departure
     */
    public int remainingHour(){
        int hourStart = getHourStart();
        int curHour = getCurHour();
        if (hourStart > curHour) {
            return hourStart - curHour;
        } else return (24 + hourStart) - curHour;
    }

    /**
     * Method for calculation remaining time between minute of departure and current minute
     * @return a point of departure
     */
    public int remainingMinute() {
        return getMinuteStart() - getCurMinute();
    }

    /**
     * Method for creating new Route object
     * @return new Route object
     */
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

    /**
     * Method for string description of object
     * @return string description of object
     */
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
