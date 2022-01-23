package tests.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateTransform {

    public static final String[] formats = {"yyyy/MM/dd", "dd/MM/yyyy", "MM-dd-yyyy"};
    public static final String NEW_FORMAT = "yyyyMMdd";

    public static List<String> transformDateFormat(List<String> dates) {
        List<String> list = new ArrayList<>();
        DateFormat targetFormat = new SimpleDateFormat(NEW_FORMAT);
        try {
            for (String format : formats) {
                for (String date : dates) {
                    if (isFormatValid(format, date)) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                        list.add(targetFormat.format(simpleDateFormat.parse(date)));
                    }
                }
            }
        } catch (ParseException ignored) {

        }
        return list;
    }

    public static boolean isFormatValid(String format, String strDate) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(strDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> dates = transformDateFormat(Arrays.asList("2010/02/20", "19/12/2016", "11-18-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }
}