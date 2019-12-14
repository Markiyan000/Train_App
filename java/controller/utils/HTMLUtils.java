package controller.utils;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HTMLUtils {
    public static void openFile() {
        try {
            URI oURL = new URI("file:///C:/Users/marki/IdeaProjects/Train_App/TrainApp.html");
            Desktop.getDesktop().browse(oURL);
        } catch (IOException exception) {
            exception.getMessage();
            exception.printStackTrace();
        } catch (URISyntaxException exception) {
            exception.getMessage();
            exception.printStackTrace();
        }
    }

    public static String formatTitle() {
        return "<h1 align = center>TrainApp</h1>";
    }

    public static String startFile() {
        return "<html>" + styleTable() + "<body><b>" + formatTitle() + "</b><br>";
    }

    public static String endFile() {
        return "</body></html>";
    }

    public static StringBuilder titleTable(String[] titles) {
        StringBuilder titleTable = new StringBuilder();
        titleTable.append("<table class=table_blur border=1 width=800 cellpadding=5><tr>");
        for (String title : titles) {
            titleTable.append("<th>" + title + "</th>");
        }
        return titleTable;
    }

    public static StringBuilder contentsTable(String[] data) {
        StringBuilder content = new StringBuilder();
        content.append("<tr>");
        for (String cur : data) {
            content.append("<td>" + cur + "</td>");
        }
        return content;
    }

    public static String styleTable() {
        return "<head><style>." +
                "table_blur {\n" +
                "  background: #f5ffff;\n" +
                "  border-collapse: collapse;\n" +
                "  text-align: center;\n" +
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
}