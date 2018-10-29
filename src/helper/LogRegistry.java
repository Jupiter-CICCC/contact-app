package helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LogRegistry {
    private static ArrayList<String> logList = new ArrayList<>();

    public static void register(String log) {
        logList.add(log);
    }
    public static String getDateNow() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public static String printableLog() {
        StringBuilder sb = new StringBuilder();
        for (int i = logList.size() - 1; i >= 0 && i >= logList.size() - 10; i--) {
            sb.append("\n - " + getDateNow() + " : " + logList.get(i));
        }
        sb.append("\n");
        return sb.toString();
    }
}
