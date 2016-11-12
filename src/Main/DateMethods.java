package Main;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMethods {
    //getDate method
    public static String returnDate(){
        DateFormat dateFormat = new SimpleDateFormat("EEEEEEEEEE dd MMMMMMMMMMMM");
        Date date = new Date();
        String dateString = dateFormat.format(date);
        return dateString;
    }

    //getYear method
    public static String returnYear() {
        DateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date year = new Date();
        return yearFormat.format(year);
    }
}
