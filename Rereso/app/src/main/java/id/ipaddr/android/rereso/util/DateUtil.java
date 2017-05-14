package id.ipaddr.android.rereso.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by iip on 5/6/17.
 */

public class DateUtil {

    public static final String FORMAT_DATE = "dd/MM/yyyy";
    public static final String FORMAT_TIME = "HH:mm";

    public static Date dateFromString(String stringDate){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        try {
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date timeFromString(String stringTime){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
        try {
            date = sdf.parse(stringTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
