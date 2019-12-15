package view;

import controller.utils.HTMLUtils;
import controller.utils.StringUtils;
import model.model_instance.carriage.Carriage;
import model.model_instance.carriage.Compartment;
import model.model_instance.carriage.Lux;
import model.model_instance.carriage.Seatpost;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.String;
import java.util.Map;

public class HTMLView implements View {
    PrintWriter printWriter;

    public HTMLView() {}

    @Override
    public void showTrains(List<Train> trains) {
        printWriter = HTMLUtils.createFile();
        StringBuilder viewPage = new StringBuilder();
        String[] title = {"ID", "Type", "Name", "From", "To", "Departure", "Arrival"};

        viewPage.append(HTMLUtils.startFile());
        viewPage.append(HTMLUtils.titleTable(title) + "</tr>");
        for (Train train : trains) {
            String[] data = {String.valueOf(train.getID()), train.getType(), train.getName(), train.getRoute().getFrom(), train.getRoute().getTo(),
                    train.getRoute().getTimeStart(), train.getRoute().getTimeFinish()};
            viewPage.append(HTMLUtils.contentsTable(data) + "</tr>");
        }

        viewPage.append(HTMLUtils.endFile());
        printWriter.println(viewPage);
        HTMLUtils.openFile();
        printWriter.close();
    }

    @Override
    public void showCalculationResult(Train train, double[] result) {
        printWriter = HTMLUtils.createFile();
        StringBuilder viewPage = new StringBuilder();
        String[] title = {"ID", "Type", "Name", "From", "To", "Departure", "Arrival", "Passengers", "Baggage"};
        String[] data = {String.valueOf(train.getID()), train.getType(), train.getName(), train.getRoute().getFrom(), train.getRoute().getTo(),
                train.getRoute().getTimeStart(), train.getRoute().getTimeFinish(), String.valueOf((int) result[0]), String.valueOf(result[1])};

        viewPage.append(HTMLUtils.startFile());
        viewPage.append(HTMLUtils.titleTable(title) + "</tr>");
        viewPage.append(HTMLUtils.contentsTable(data));
        viewPage.append(HTMLUtils.endFile());

        printWriter.println(viewPage);
        HTMLUtils.openFile();
        printWriter.close();
    }

    @Override
    public void showTrain(Train train) {
        printWriter = HTMLUtils.createFile();
        StringBuilder viewPage = new StringBuilder();
        String[] trainTitle = {"ID", "Type", "Name"};
        String[] carriageTitle = {"ID", "Type", "Number of seats", "Conditioner", "Food", "Press", "TV", "Washstand"};
        String[] routeTitle = {"From", "To", "Departure", "Arrival"};
        String[] stopsTitle = {"Name","Duration"};
        String[] dataTrain = {String.valueOf(train.getID()), train.getType(), train.getName()};
        String[] dataRoute = {train.getRoute().getFrom(), train.getRoute().getTo(),
                train.getRoute().getTimeStart(), train.getRoute().getTimeFinish()};

        viewPage.append(HTMLUtils.startFile());
        viewPage.append(HTMLUtils.titleTable(trainTitle) + "</tr>");
        viewPage.append(HTMLUtils.contentsTable(dataTrain) + "</tr>");
        viewPage.append(HTMLUtils.titleTable(routeTitle) + "</tr>");
        viewPage.append(HTMLUtils.contentsTable(dataRoute) + "</tr>");
        viewPage.append(HTMLUtils.titleTable(stopsTitle));
        Iterator<Map.Entry<String,Integer>> entryIterator = train.getRoute().getStops().entrySet().iterator();
        while(entryIterator.hasNext()) {
            List<String> dataStop = new ArrayList<>();
            Map.Entry<String, Integer> current = entryIterator.next();
            dataStop.add(current.getKey());
            dataStop.add(String.valueOf(current.getValue()));
            viewPage.append(HTMLUtils.contentsTable(dataStop.toArray(new String[dataStop.size()])));
        }

        viewPage.append(HTMLUtils.titleTable(carriageTitle) + "</tr>");
        List<Carriage> carriages = ((PassengerTrain) train).getCarriages();
        for (Carriage carriage : carriages) {
            List<String> data = new ArrayList<String>();
            data.add(String.valueOf(carriage.getID()));
            data.add(carriage.getType());
            data.add(String.valueOf(carriage.getNumberSeats()));
            if (carriage instanceof Seatpost) {
                data.add(StringUtils.changeFromBoolean(((Seatpost) carriage).isConditioner()));
            }
            if (carriage instanceof Compartment) {
                data.add(StringUtils.changeFromBoolean(((Compartment) carriage).isConditioner()));
                data.add(StringUtils.changeFromBoolean(((Compartment) carriage).isPress()));
                data.add(StringUtils.changeFromBoolean(((Compartment) carriage).isFood()));
            }
            if (carriage instanceof Lux) {
                data.add(StringUtils.changeFromBoolean(((Lux) carriage).isConditioner()));
                data.add(StringUtils.changeFromBoolean(((Lux) carriage).isPress()));
                data.add(StringUtils.changeFromBoolean(((Lux) carriage).isFood()));
                data.add(StringUtils.changeFromBoolean(((Lux) carriage).isTV()));
                data.add(StringUtils.changeFromBoolean(((Lux) carriage).isWashStand()));
            }
            String[] fromList = data.toArray(new String[data.size()]);
            viewPage.append(HTMLUtils.contentsTable((fromList)) + "</tr>");
        }
        viewPage.append(HTMLUtils.endFile());
        printWriter.println(viewPage);
        HTMLUtils.openFile();
        printWriter.close();
    }

    @Override
    public void showFindFreeResult(Train train, Map<Carriage, Integer> found) {
        printWriter = HTMLUtils.createFile();
        StringBuilder viewPage = new StringBuilder();
        String trainTitle[] = {"ID","Type","Name","From","To","Departure","Arrival"};
        String carriageTitle[] = {"ID","Type","Free seats"};
        String []dataTrain = {String.valueOf(train.getID()), train.getType(), train.getName(), train.getRoute().getFrom(), train.getRoute().getTo(),
                train.getRoute().getTimeStart(), train.getRoute().getTimeFinish()};
        viewPage.append((HTMLUtils.startFile()));
        viewPage.append(HTMLUtils.titleTable(trainTitle));
        viewPage.append(HTMLUtils.contentsTable(dataTrain));
        viewPage.append(HTMLUtils.titleTable(carriageTitle));
        Iterator<Map.Entry<Carriage, Integer>> entries = found.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Carriage, Integer> entry = entries.next();
            List<String> dataCarriage = new ArrayList<>();
            dataCarriage.add(String.valueOf(entry.getKey().getID()));
            dataCarriage.add(entry.getKey().getType());
            dataCarriage.add(String.valueOf(entry.getValue()));
            viewPage.append(HTMLUtils.contentsTable(dataCarriage.toArray(new String[dataCarriage.size()])));
        }
        viewPage.append(HTMLUtils.endFile());

        printWriter.println(viewPage);
        HTMLUtils.openFile();
        printWriter.close();
    }
}
