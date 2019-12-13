package view;

import model.model_instance.train.PassengerTrain;
import model.model_instance.train.Train;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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

    public void openFile(){
        try {
            URI oURL = new URI("file:///C:/Users/marki/IdeaProjects/Train_App/TrainApp.html");
            Desktop.getDesktop().browse(oURL);
        }catch(IOException exception){
            exception.getMessage();
            exception.printStackTrace();
        }catch(URISyntaxException exception) {
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

    @Override
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
            viewPage.append("<td>" + ((PassengerTrain) train).getNumberPassengers() + "</td>");
            viewPage.append("</tr>");
        }
        viewPage.append(endFile());
        printWriter.println(viewPage);
        openFile();
        printWriter.close();
    }

    @Override
    public void showBaggageResult(Train train, double baggage) {
        StringBuilder viewPage = new StringBuilder();
        viewPage.append(startFile());
        viewPage.append(train.getName() + " has " + baggage + " kilograms of baggage.");
        viewPage.append(endFile());
        printWriter.println(viewPage);
        openFile();
        printWriter.close();
    }
}
