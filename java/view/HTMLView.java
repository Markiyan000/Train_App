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

    public String styleTable() {
        return "<head><style>." +
                "table_blur {\n" +
                "  background: #f5ffff;\n" +
                "  border-collapse: collapse;\n" +
                "  text-align: left;\n" +
                "}\n" +
                ".table_blur th {\n" +
                "  border-top: 1px solid #777777;\t\n" +
                "  border-bottom: 1px solid #777777; \n" +
                "  box-shadow: inset 0 1px 0 #999999, inset 0 -1px 0 #999999;\n" +
                "  background: linear-gradient(#9595b6, #5a567f);\n" +
                "  color: white;\n" +
                "  padding: 10px 15px;\n" +
                "  position: relative;\n" +
                "}\n" +
                ".table_blur th:after {\n" +
                "  content: \"\";\n" +
                "  display: block;\n" +
                "  position: absolute;\n" +
                "  left: 0;\n" +
                "  top: 25%;\n" +
                "  height: 25%;\n" +
                "  width: 100%;\n" +
                "  background: linear-gradient(rgba(255, 255, 255, 0), rgba(255,255,255,.08));\n" +
                "}\n" +
                ".table_blur tr:nth-child(odd) {\n" +
                "  background: #ebf3f9;\n" +
                "}\n" +
                ".table_blur th:first-child {\n" +
                "  border-left: 1px solid #777777;\t\n" +
                "  border-bottom:  1px solid #777777;\n" +
                "  box-shadow: inset 1px 1px 0 #999999, inset 0 -1px 0 #999999;\n" +
                "}\n" +
                ".table_blur th:last-child {\n" +
                "  border-right: 1px solid #777777;\n" +
                "  border-bottom:  1px solid #777777;\n" +
                "  box-shadow: inset -1px 1px 0 #999999, inset 0 -1px 0 #999999;\n" +
                "}\n" +
                ".table_blur td {\n" +
                "  border: 1px solid #e3eef7;\n" +
                "  padding: 10px 15px;\n" +
                "  position: relative;\n" +
                "  transition: all 0.5s ease;\n" +
                "}\n" +
                ".table_blur tbody:hover td {\n" +
                "  color: transparent;\n" +
                "  text-shadow: 0 0 3px #a09f9d;\n" +
                "}\n" +
                ".table_blur tbody:hover tr:hover td {\n" +
                "  color: #444444;\n" +
                "  text-shadow: none;\n" +
                "}" +
                "</style></head>";
    }

    public String formatTitle() {
        return "<h1 align = center>TrainApp</h1>";
    }

    public String startFile() {
        return "<html>" + styleTable() + "<body><b>" + formatTitle() + "</b><br>";
    }

    public String endFile() {
        return "</body></html>";
    }

    @Override
    public void showTrains(List<Train> trains) {
        StringBuilder viewPage = new StringBuilder();
        viewPage.append(startFile());
        viewPage.append("<table class=table_blur border=1 width=800  cellpadding=5>");
        viewPage.append("<tr><th>ID</th><th>Type</th><th>Name</th><th>From</th><th>To</th>" +
                "<th>Time of start</th><th>Time of finish</th></tr>");
        for (Train train : trains) {
            viewPage.append("<tr>");
            viewPage.append("<td>" + train.getID() + "</td>");
            viewPage.append("<td>" + train.getType() + "</td>");
            viewPage.append("<td>" + train.getName() + "</td>");
            viewPage.append("<td>" + train.getRoute().getFrom() + "</td>");
            viewPage.append("<td>" + train.getRoute().getTo() + "</td>");
            viewPage.append("<td>" + train.getRoute().getTimeStart() + "</td>");
            viewPage.append("<td>" + train.getRoute().getTimeFinish() + "</td>");
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
