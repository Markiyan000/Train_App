package view;

import controller.utils.HTMLUtils;
import controller.utils.StringUtils;
import model.model_instance.carriage.Carriage;
import model.model_instance.carriage.Compartment;
import model.model_instance.carriage.Lux;
import model.model_instance.carriage.Seatpost;
import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class HTMLView implements View {
    PrintWriter printWriter;

    public HTMLView() {
        try {
            printWriter = new PrintWriter("TrainApp.html", "UTF-8");
        } catch (FileNotFoundException exception) {
            exception.getMessage();
            exception.printStackTrace();
        } catch (UnsupportedEncodingException exception) {
            exception.getMessage();
            exception.printStackTrace();
        }
    }

    @Override
    public void showTrains(List<Train> trains) {
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
        StringBuilder viewPage = new StringBuilder();
        String[] title = {"ID", "Type", "Name", "From", "To", "Departure", "Arrival"};
        String[] data = {String.valueOf(train.getID()), train.getType(), train.getName(), train.getRoute().getFrom(), train.getRoute().getTo(),
                train.getRoute().getTimeStart(), train.getRoute().getTimeFinish()};

        viewPage.append(HTMLUtils.startFile());
        viewPage.append(HTMLUtils.titleTable(title) + "<th>The current number of passengers</th><th>The number of baggage</th>");
        viewPage.append(HTMLUtils.contentsTable(data) + "<td>" + result[0] + "</td>" + "<td>" + result[1] + "</td>" + "</tr>");
        viewPage.append(HTMLUtils.endFile());

        printWriter.println(viewPage);
        HTMLUtils.openFile();
        printWriter.close();
    }

    @Override
    public void showTrain(Train train) {
        StringBuilder viewPage = new StringBuilder();
        String[] dataTrain = {String.valueOf(train.getID()), train.getType(), train.getName()};
        String[] dataRoute = {train.getRoute().getFrom(), train.getRoute().getTo(),
                train.getRoute().getTimeStart(), train.getRoute().getTimeFinish()};
        String[] trainTitle = {"ID", "Type", "Name"};
        String[] carriageTitle = {"ID", "Type", "Number of seats", "Conditioner", "Food", "Press", "TV", "Washstand"};
        String[] routeTitle = {"From", "To", "Departure", "Arrival"};

        viewPage.append(HTMLUtils.startFile());
        viewPage.append(HTMLUtils.titleTable(trainTitle) + "</tr>");
        viewPage.append(HTMLUtils.contentsTable(dataTrain) + "</tr>");
        viewPage.append(HTMLUtils.titleTable(routeTitle) + "</tr>");
        viewPage.append(HTMLUtils.contentsTable(dataRoute) + "</tr>");
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
}
