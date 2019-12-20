package controller.utils;

import controller.Controller;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Class with methods to create HTML page
 */


public class HTMLUtils {

    /**
     * Method for creating HTML file
     *
     * @return - created HTML file or null
     */
    public static PrintWriter createFile() {
        Controller.logger.info("Creation HTML file.");
        try {
            return new PrintWriter("TrainApp.html", "UTF-8");
        } catch (FileNotFoundException exception) {
            Controller.logger.error("ERROR!!! File isn't found!", exception);
            exception.getMessage();
        } catch (UnsupportedEncodingException exception) {
            Controller.logger.error("ERROR!!! Encoding problems!", exception);
            exception.getMessage();
        }
        return null;
    }

    /**
     * Method for opening HTML file while the program is running
     */
    public static void openFile() {
        Controller.logger.info("Open HTML file for user.");
        try {
            URI oURL = new URI("file:///C:/Users/marki/IdeaProjects/Train_App/TrainApp.html");
            Desktop.getDesktop().browse(oURL);
        } catch (IOException exception) {
            Controller.logger.error("ERROR while opening file!!!", exception);
            exception.getMessage();
        } catch (URISyntaxException exception) {
            Controller.logger.error("ERROR while opening file!!!", exception);
            exception.getMessage();
        }
    }

    /**
     * Method for creating title of page
     *
     * @return title
     */
    public static String formatTitle() {
        return "<h1 align = center>TrainApp</h1>";
    }

    /**
     * Method for creating body and style tags
     *
     * @return page header
     */
    public static String startFile() {
        return "<html>" + styleTable() + "<body><b>" + formatTitle() + "</b><br>";
    }

    /**
     * Method for closing all main tags
     *
     * @return two closed tags
     */
    public static String endFile() {
        return "</body></html>";
    }

    /**
     * Method for creating title of table
     *
     * @param titles - content of title
     * @return - created title of table
     */
    public static StringBuilder titleTable(String[] titles) {
        StringBuilder titleTable = new StringBuilder();
        titleTable.append("<table class=table_blur border=1 width=800 cellpadding=5><tr>");
        for (String title : titles) {
            titleTable.append("<th>" + title + "</th>");
        }
        return titleTable;
    }

    /**
     * Method for creating title of table
     *
     * @param data - content of table
     * @return - created table
     */
    public static StringBuilder contentsTable(String[] data) {
        StringBuilder content = new StringBuilder();
        content.append("<tr>");
        for (String cur : data) {
            content.append("<td>" + cur + "</td>");
        }
        return content;
    }

    /**
     * Method for describing style of table
     *
     * @return style of table
     */
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