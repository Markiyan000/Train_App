package view;

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

    public void showTrains(List<Train> trains) {
        String title = String.format("%-1s %10s %10s %15s %20s %15s", "ID", "Type", "Name",
                "Carriages", "Passengers", "Current");
        String viewPage = "<html><body>" + "<b>" + formatTitle() + title + "</b><br>";
        for (Train train : trains) {
            viewPage += train.toString() + "<br>";
        }
        viewPage += "</body></html>";
        printWriter.println(viewPage);
        printWriter.close();
    }

    public void showBaggageResult(Train train, double baggage) {
        String viewPage = "<html><body>" + "<b>" + formatTitle() + "</b><br>";
        viewPage += train.getName() + " has " + baggage + " kilograms of baggage.";
        printWriter.println(viewPage);
        printWriter.close();
    }
}
