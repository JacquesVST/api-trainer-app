package tk.jvst.api.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateTimeUtilities {

    public static Timestamp stringDateToTimestamp(String dataString) {
        String[] splitDate = dataString.split("/");
        String formattedDate = splitDate[2] + "-" + splitDate[1] + "-" + splitDate[0] + " 00:00:00";
        return Timestamp.valueOf(formattedDate);
    }

    public static String timestampToStringDate(Timestamp date) {
        if(date == null){
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
