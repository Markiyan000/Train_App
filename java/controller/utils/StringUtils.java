package controller.utils;

public class StringUtils {
    public static String changeFromBoolean(boolean value) {
        return value == true ? "Yes" : "No";
    }

    public static int[] splitTime(String time) {
        int[] res = new int[2];
        String[] splitted = time.split(":", 2);
        for (int i = 0; i < 2; i++) {
            res[i] = Integer.parseInt(splitted[i]);
        }
        return res;
    }
}