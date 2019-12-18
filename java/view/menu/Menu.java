package view.menu;

import java.util.Scanner;

public class Menu {
    public static int showMenu(int who) {
        String color1 = "";
        String color2 = "";
        if (who == 1) {
            color1 = Color.RED.code;
            color2 = Color.GREEN.code;
        }
        if (who == 2) {
            color1 = Color.GREEN.code;
            color2 = Color.RED.code;
        }
        System.out.println("\t\t MENU\n" + Color.STANDARD.code + "\t\t" + color1 + "1) Create train\n\t\t" +
                "2) Delete train\n\t\t3) Delete list of trains\n\t\t" + color2 + "4) Show trains\n" + "\t\t5) Show train\n" +
                "\t\t6) Determine the number of passengers and baggage\n" + "\t\t7) Search by criterion passengers\n" +
                "\t\t8) Search trains go to the given city\n\t\t9) Search free seats in train\n" +
                "\t\t10) Sort carriages by comfort\n\t\t11) Sort trains\n" + "\t\t0) Exit\n" + Color.STANDARD.code);
        return new Scanner(System.in).nextInt();
    }
}
