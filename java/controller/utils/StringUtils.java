package controller.utils;

/**
 * Class with static function for working with strings
 */

public class StringUtils {

    /**
     * Method for converting boolean value in string value (true - "Yes",false - "No")
     * @param value boolean value for converting
     * @return converted value
     */
    public static String convertBoolean(boolean value) {
        return value == true ? "Yes" : "No";
    }

    /**
     * Method for splitting string and save it in integer array
     * @param time time is represented as string
     * @return integer array with two values (hour and minute)
     * */
    public static int[] splitTime(String time) {
        int[] res = new int[2];
        String[] splitted = time.split(":", 2);
        for (int i = 0; i < 2; i++) {
            res[i] = Integer.parseInt(splitted[i]);
        }
        return res;
    }
}