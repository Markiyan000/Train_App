package view;

import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

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

    public String formatTitle() {
        return "<h1 align = center>TrainApp</h1>";
    }

    public String startFile() {
        return "<html><body><b>" + formatTitle() + "</b><br>";
    }

    public String endFile() {
        return "</body></html>";
    }

    public void showTrains(List<Train> trains) {
        StringBuilder viewPage = new StringBuilder();
        viewPage.append(startFile());
        viewPage.append("<table border=1 bordercolor=red width=100 cellpadding=5>");
        viewPage.append("<tr><th>ID</th><th>Type</th><th>Name</th><th>Carriage</th><th>Passengers</th><th>Current</th></tr>");
        for (Train train : trains) {
            viewPage.append("<tr>");
            viewPage.append("<td>" + train.getID() + "</td>");
            viewPage.append("<td>" + train.getType() + "</td>");
            viewPage.append("<td>" + train.getName() + "</td>");
            viewPage.append("<td>" + train.getNumberCarriages() + "</td>");
            viewPage.append("<td>" + ((PassengerTrain) train).getNumberPassengers() + "</td>");
            viewPage.append("<td>" + ((PassengerTrain) train).getCurNumberPassengers() + "</td><br>");
            viewPage.append("</tr>");
        }
        viewPage.append(endFile());
        printWriter.println(viewPage);
        printWriter.close();
    }

    public void showBaggageResult(Train train, double baggage) {
        StringBuilder viewPage = new StringBuilder();
        viewPage.append(startFile());
        viewPage.append(train.getName() + " has " + baggage + " kilograms of baggage.");
        viewPage.append(endFile());
        printWriter.println(viewPage);
        printWriter.close();
    }
}
